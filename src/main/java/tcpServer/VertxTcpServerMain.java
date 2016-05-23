package tcpServer;

import httpServer.VertxHttpClientVerticle;
import io.vertx.core.Vertx;

/**
 * Created by boki on 5/23/16.
 */
public class VertxTcpServerMain {
    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VertxTcpServerVerticle());
    }
}
