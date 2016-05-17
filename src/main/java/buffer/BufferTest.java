package buffer;

import io.vertx.core.buffer.Buffer;

/**
 * Created by bernie on 2016/5/17.
 */
public class BufferTest {
    public static void main(String[] args) {
        Buffer buffer = Buffer.buffer();

        System.out.println("buffer.length() = " + buffer.length());
        buffer.setByte  ( 0, (byte)  127);
        buffer.setShort ( 2, (short) 127);
        buffer.setInt   ( 4,         127);
        buffer.setLong  ( 8,         127);
        buffer.setFloat (16,      127.0F);
        buffer.setDouble(20,      127.0D);

        System.out.println("buffer.length() = " + buffer.length());

        buffer = Buffer.buffer();
        System.out.println("buffer.length() = " + buffer.length());

        buffer.appendByte  ((byte)  127);
        buffer.appendShort ((short) 127);
        buffer.appendInt   (        127);
        buffer.appendLong  (        127);
        buffer.appendFloat (     127.0F);
        buffer.appendDouble(     127.0D);

        System.out.println("buffer.length() = " + buffer.length());
    }
}
