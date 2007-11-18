package com.xurmo.connect.user;
import java.io.*;

public class XurmoBase64EncoderStream extends FilterOutputStream {
    private byte[] buffer; 	// cache of bytes that are yet to be encoded
    private int bufsize = 0;	// size of the cache
    private int count = 0; 	// number of bytes that have been output
    private int bytesPerLine;	// number of bytes per line

    /**
     * Create a BASE64 encoder that encodes the specified input stream
     * @param out        the output stream
     * @param bytesPerLine  number of bytes per line. The encoder inserts
     * 			 a CRLF sequence after the specified number of bytes
     */
    public XurmoBase64EncoderStream(OutputStream out, int bytesPerLine) {
	super(out);
	buffer = new byte[3];
	this.bytesPerLine = bytesPerLine;
    }

    /**
     * Create a BASE64 encoder that encodes the specified input stream.
     * Inserts the CRLF sequence after outputting 76 bytes.
     * @param out        the output stream
     */
    public XurmoBase64EncoderStream(OutputStream out) {
	this(out, 76);	
    }

    /**
     * Encodes <code>len</code> bytes from the specified
     * <code>byte</code> array starting at offset <code>off</code> to
     * this output stream.
     *
     * @param      b     the data.
     * @param      off   the start offset in the data.
     * @param      len   the number of bytes to write.
     * @exception  IOException  if an I/O error occurs.
     */
    public void write(byte[] b, int off, int len) throws IOException {
	for (int i = 0; i < len; i++)
	    write(b[off + i]);
    }

    /**
     * Encodes <code>b.length</code> bytes to this output stream.
     * @param      b   the data to be written.
     * @exception  IOException  if an I/O error occurs.
     */
    public void write(byte[] b) throws IOException {
	write(b, 0, b.length);
    }

    /**
     * Encodes the specified <code>byte</code> to this output stream.
     * @param      c   the <code>byte</code>.
     * @exception  IOException  if an I/O error occurs.
     */
    public void write(int c) throws IOException {
	buffer[bufsize++] = (byte)c;
	if (bufsize == 3) { // Encoding unit = 3 bytes
	    encode();
	    bufsize = 0;
	}
    }

    /**
     * Flushes this output stream and forces any buffered output bytes
     * to be encoded out to the stream. 
     * @exception  IOException  if an I/O error occurs.
     */
    public void flush() throws IOException {
	if (bufsize > 0) { // If there's unencoded characters in the buffer ..
	    encode();      // .. encode them
	    bufsize = 0;
	}
	out.flush();
    }

    /**
     * Forces any buffered output bytes to be encoded out to the stream
     * and closes this output stream
     */
    public void close() throws IOException {
	flush();
	out.close();
    }

    /** This array maps the characters to their 6 bit values */
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

    private void encode() throws IOException {
	// If writing out this encoded unit will cause overflow,
	// start a new line.
	if (count + 4 > bytesPerLine) {
	    out.write('\r');
	    out.write('\n');
	    count = 0;
	}

	byte a, b, c;
	if (bufsize == 1) {
	    a = buffer[0];
	    b = 0;
	    c = 0;
	    out.write(pem_array[(a >>> 2) & 0x3F]);
	    out.write(pem_array[((a << 4) & 0x30) + ((b >>> 4) & 0xf)]);
	    out.write('='); // pad character
	    out.write('='); // pad character
	} else if (bufsize == 2) {
	    a = buffer[0];
	    b = buffer[1];
	    c = 0;
	    out.write(pem_array[(a >>> 2) & 0x3F]);
	    out.write(pem_array[((a << 4) & 0x30) + ((b >>> 4) & 0xf)]);
	    out.write(pem_array[((b << 2) & 0x3c) + ((c >>> 6) & 0x3)]);
	    out.write('='); // pad character
	} else {
	    a = buffer[0];
	    b = buffer[1];
	    c = buffer[2];
	    out.write(pem_array[(a >>> 2) & 0x3F]);
	    out.write(pem_array[((a << 4) & 0x30) + ((b >>> 4) & 0xf)]);
	    out.write(pem_array[((b << 2) & 0x3c) + ((c >>> 6) & 0x3)]);
	    out.write(pem_array[c & 0x3F]);
        }

	// increment count
	count += 4;
    }

    /**
     * Base64 encode a byte array.  No line breaks are inserted.
     * This method is suitable for short strings, such as those
     * in the IMAP AUTHENTICATE protocol, but not to encode the
     * entire content of a MIME part.
     */
    public static byte[] encode(byte[] inbuf) {
	if (inbuf.length == 0)
	    return inbuf;
	byte[] outbuf = new byte[((inbuf.length + 2) / 3) * 4];
	int inpos = 0, outpos = 0;
	int size = inbuf.length;
	while (size > 0) {
	    byte a, b, c;
	    if (size == 1) {
		a = inbuf[inpos++];
		b = 0;
		c = 0;
		outbuf[outpos++] = (byte)pem_array[(a >>> 2) & 0x3F];
		outbuf[outpos++] =
			(byte)pem_array[((a << 4) & 0x30) + ((b >>> 4) & 0xf)];
		outbuf[outpos++] = (byte)'=';  // pad character
		outbuf[outpos++] = (byte)'=';  // pad character
	    } else if (size == 2) {
		a = inbuf[inpos++];
		b = inbuf[inpos++];
		c = 0;
		outbuf[outpos++] = (byte)pem_array[(a >>> 2) & 0x3F];
		outbuf[outpos++] =
			(byte)pem_array[((a << 4) & 0x30) + ((b >>> 4) & 0xf)];
		outbuf[outpos++] =
			(byte)pem_array[((b << 2) & 0x3c) + ((c >>> 6) & 0x3)];
		outbuf[outpos++] = (byte)'=';  // pad character
	    } else {
		a = inbuf[inpos++];
		b = inbuf[inpos++];
		c = inbuf[inpos++];
		outbuf[outpos++] = (byte)pem_array[(a >>> 2) & 0x3F];
		outbuf[outpos++] =
			(byte)pem_array[((a << 4) & 0x30) + ((b >>> 4) & 0xf)];
		outbuf[outpos++] =
			(byte)pem_array[((b << 2) & 0x3c) + ((c >>> 6) & 0x3)];
		outbuf[outpos++] = (byte)pem_array[c & 0x3F];
	    }
	    size -= 3;
	}
	return outbuf;
    }
}
