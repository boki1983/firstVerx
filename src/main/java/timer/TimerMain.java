package timer;

import httpServer.VertxHttpClientVerticle;
import io.vertx.core.Vertx;

/**
 * Created by boki on 5/22/16.
 */
public class TimerMain {
    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new OneTimeTimer());
        vertx.deployVerticle(new PeriodicTimers());
    }
}
