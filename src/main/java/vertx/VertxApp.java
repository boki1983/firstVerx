package vertx;

import io.vertx.core.Vertx;

/**
 * Created by bernie on 2016/5/10.
 */
public class VertxApp {
    public static void main(String[] args) {
        /*The Vertx instance creates a number of threads internally to
        handle the exchange of messages between verticles.*/
        Vertx vertx = Vertx.vertx();

        // Using deployVerticle() to deploy verticle
        vertx.deployVerticle(new MyVerticle());
    }
}
