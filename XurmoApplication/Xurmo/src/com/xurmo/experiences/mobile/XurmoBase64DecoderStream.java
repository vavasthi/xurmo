
package com.xurmo.experiences.mobile;

import java.io.*;


public class XurmoBase64DecoderStream extends DataInputStream {
    private byte[] buffer; 	// cache of decoded bytes
    private int bufsize = 0;	// size of the cache
    private int index = 0;	// index into the cache

    public XurmoBase64DecoderStream(InputStream in) {
	super(in);
	buffer = new byte[3];
    }

    /**
     * Read the next decoded byte from this input stream. The byte
     * is returned as an <code>int</code> in the range <code>0</code> 
     * to <code>255</code>. If no byte is available because the end of 
     * the stream has been reached, the value <code>-1</code> is returned.
     * This method blocks until input data is available, the end of the 
     * stream is detected, or an exception is thrown.
     *
     * @return     next byte of data, or <code>-1</code> if the end of the
     *             stream is reached.
     * @exception  IOException  if an I/O error occurs.
     * @see        java.io.FilterInputStream#in
     */
    public int read() throws IOException {
	if (index >= bufsize) {
	    decode(); // Fills up buffer
	    if (bufsize == 0) // buffer is empty
		return -1;
	    index = 0; // reset index into buffer
	}
	return buffer[index++] & 0xff; // Zero off the MSB
    }

    /**
     * Tests if this input stream supports marks. Currently this class
     * does not support marks
     */
    public boolean markSupported() {
	return false; // Maybe later ..
    }

    /**
     * Returns the number of bytes that can be read from this input
     * stream without blocking. However, this figure is only
     * a close approximation in case the original encoded stream
     * contains embedded CRLFs; since the CRLFs are discarded, not decoded
     */ 
    public int available() throws IOException {
	 // This is only an estimate, since in.available()
	 // might include CRLFs too ..
	 return ((in.available() * 3)/4 + (bufsize-index));
    }

    /**
     * This character array provides the character to value map
     * based on RFC1521.
     */  
    private final static char pem_array[] = {
	'A','B','C','D','E','F','G','H', // 0
	'I','J','K','L','M','N','O','P', // 1
	'Q','R','S','T','U','V','W','X', // 2
	'Y','Z','a','b','c','d','e','f', // 3
	'g','h','i','j','k','l','m','n', // 4
	'o','p','q','r','s','t','u','v', // 5
	'w','x','y','z','0','1','2','3', // 6
	'4','5','6','7','8','9','+','/'  // 7
    };

    private final static byte pem_convert_array[] = new byte[256];

    static {
	for (int i = 0; i < 255; i++)
	    pem_convert_array[i] = -1;
	for(int i = 0; i < pem_array.length; i++)
	    pem_convert_array[pem_array[i]] = (byte) i;
    }

    /* The decoder algorithm */
    private byte[] decode_buffer = new byte[4];
    private void decode() throws IOException {
	bufsize = 0;
	/*
	 * We need 4 valid base64 characters before we start decoding.
	 * We skip anything that's not a valid base64 character (usually
	 * just CRLF).
	 */
	int got = 0;
	while (got < 4) {
	    int i = in.read();
	    if (i == -1) {
		if (got == 0)
		    return;	// EOF before any data is ok
		throw new IOException("Error in encoded stream, got " + got);
	    }
	    if (i >= 0 && i < 256 && i == '=' || pem_convert_array[i] != -1)
		decode_buffer[got++] = (byte)i;
	}

	byte a, b;
	a = pem_convert_array[decode_buffer[0] & 0xff];
	b = pem_convert_array[decode_buffer[1] & 0xff];
	// The first decoded byte
	buffer[bufsize++] = (byte)(((a << 2) & 0xfc) | ((b >>> 4) & 3));

	if (decode_buffer[2] == '=') // End of this BASE64 encoding
	    return;
	a = b;
	b = pem_convert_array[decode_buffer[2] & 0xff];
	// The second decoded byte
	buffer[bufsize++] = (byte)(((a << 4) & 0xf0) | ((b >>> 2) & 0xf));

	if (decode_buffer[3] == '=') // End of this BASE64 encoding
	    return;
	a = b;
	b = pem_convert_array[decode_buffer[3] & 0xff];
	// The third decoded byte
	buffer[bufsize++] = (byte)(((a << 6) & 0xc0) | (b & 0x3f));
    }

    /**
     * Base64 decode a byte array.  No line breaks are allowed.
     * This method is suitable for short strings, such as those
     * in the IMAP AUTHENTICATE protocol, but not to decode the
     * entire content of a MIME part.
     *
     * NOTE: inbuf may only contain valid base64 characters.
     *       Whitespace is not ignored.
     */
    public static byte[] decode(byte[] inbuf) {
	int size = (inbuf.length / 4) * 3;
	if (size == 0)
	    return inbuf;

	if (inbuf[inbuf.length - 1] == '=') {
	    size--;
	    if (inbuf[inbuf.length - 2] == '=')
		size--;
	}
	byte[] outbuf = new byte[size];

	int inpos = 0, outpos = 0;
	size = inbuf.length;
	while (size > 0) {
	    byte a, b;
	    a = pem_convert_array[inbuf[inpos++] & 0xff];
	    b = pem_convert_array[inbuf[inpos++] & 0xff];
	    // The first decoded byte
	    outbuf[outpos++] = (byte)(((a << 2) & 0xfc) | ((b >>> 4) & 3));

	    if (inbuf[inpos] == '=') // End of this BASE64 encoding
		return outbuf;
	    a = b;
	    b = pem_convert_array[inbuf[inpos++] & 0xff];
	    // The second decoded byte
	    outbuf[outpos++] = (byte)(((a << 4) & 0xf0) | ((b >>> 2) & 0xf));

	    if (inbuf[inpos] == '=') // End of this BASE64 encoding
		return outbuf;
	    a = b;
	    b = pem_convert_array[inbuf[inpos++] & 0xff];
	    // The third decoded byte
	    outbuf[outpos++] = (byte)(((a << 6) & 0xc0) | (b & 0x3f));
	    size -= 4;
	}
	return outbuf;
    }

}
