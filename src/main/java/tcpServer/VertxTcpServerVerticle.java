package tcpServer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;

/**
 * Created by boki on 5/23/16.
 */
public class VertxTcpServerVerticle extends AbstractVerticle {
    NetServer server = null;

    @Override
    public void start() throws Exception {
        // create a Vert.x TCP server by calling the createNetServer() method
        server = vertx.createNetServer();

        // set a connect handler on the TCP server
        server.connectHandler(netSocket -> {
            // The handle() method of the connect handler is called
            // whenever a new TCP connection is created by a client of the TCP server
            System.out.println("Incoming connection!");

            // In order to read data from the incoming connections you need to
            // set a handler on the NetSocket object for the connection
            netSocket.handler(buffer -> {
                System.out.println("incoming data: "+buffer.length());

                String data = buffer.getString(0, buffer.length());

                Buffer outBuffer = Buffer.buffer();
                outBuffer.appendString("response...");
                // The write() method of the NetSocket method is asynchronous.
                netSocket.write(outBuffer);
            });
        });

        // listen on TCP port 10000
        server.listen(10000);
    }

    // Closing the TCP server is an asynchronous actions, so the close() method
    // may exit before the TCP server is actually closed.
    public void stop() throws Exception {
        //  If you need to be notified of when the TCP server has shut down,
        // you can pass a Handler to the close() method
        server.close(voidAsyncResult -> {
            // This handler will then be called when the TCP server is fully closed.
            if(voidAsyncResult.succeeded()){
                //TCP server fully closed
            }
        });
    }
    // CL: nc localhost 10000
    // send a udp packet : echo -n "foo" | nc 192.168.1.8 5000
    // get page source : printf "GET / HTTP/1.0\r\n\r\n" | nc localhost 10000
}
