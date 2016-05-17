package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by bernie on 2016/5/10.
 */
public class EventBusSenderVerticle extends AbstractVerticle {
    public void start(Future<Void> startFuture) {
        // The publish method sends the message to all verticles listening on a given address
        vertx.eventBus().publish("anAddress", "message 2");
        // The send() method sends the message to just one of the listening verticles, which is chosen by vertx.
        vertx.eventBus().send("anAddress", "message 1");
    }
}
