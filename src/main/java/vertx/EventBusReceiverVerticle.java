package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by bernie on 2016/5/10.
 */
public class EventBusReceiverVerticle extends AbstractVerticle {

    private String name = null;

    public EventBusReceiverVerticle(String name) {
        this.name = name;
    }

    public void start(Future<Void> startFuture) {
        // A verticle can obtain a reference to the event bus via the vertx instance inherited from AbstractVerticle
        // verticle that registers a consumer (listener) of messages on the Vert.x event bus with the address anAddress
        vertx.eventBus().consumer("anAddress", message -> {
            System.out.println(this.name + " received message: " + message.body());
        });
    }
}
