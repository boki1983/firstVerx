package vertxHttpServer;

import io.vertx.core.Vertx;

/**
 * Created by bernie on 2016/5/17.
 */
public class VertxServerMain {
    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VertxHttpServerVerticle());
    }
}
