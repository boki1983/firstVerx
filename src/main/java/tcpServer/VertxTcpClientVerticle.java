package tcpServer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

/**
 * Created by boki on 5/24/16.
 */
public class VertxTcpClientVerticle extends AbstractVerticle {

    public void start() {
        // create a TCP client by creating an instance of NetClient
        NetClient tcpClient = vertx.createNetClient();

        // connect to a remote server by calling the connect() method.
        // pass the TCP port of the remote server as well as the domain name,
        // and a Handler object which is called when the connection is established
        tcpClient.connect(80, "jenkov.com", netSocketAsyncResult -> {
            // obtain a reference to the NetSocket connected to the remote server
            // via the AsyncResult instance passed to the handler's handle() method.
            NetSocket socket = netSocketAsyncResult.result();
            // The write() method is asynchronous and returns immediately.
            socket.write("GET / HTTP/1.1\r\nHost: jenkov.com\r\n\r\n");

            // In order to read data from the NetSocket you need to register a Handler method on the NetSocket.
            // The Handler's handle() method will get called when data is received from the remote server.
            socket.handler(buffer -> {
                System.out.println("Received data: " + buffer.length());

                System.out.println(buffer.getString(0, buffer.length()));
            });
        });
    }
}
