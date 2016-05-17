package vertx;

import io.vertx.core.Vertx;

/**
 * Created by bernie on 2016/5/10.
 */
public class VertxVerticleMain {
    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();
        // Once Vert.x deploys the verticle, the verticle's start() method is called.

        // The verticle will be deployed asynchronously
        // If you need to know exactly when a verticle is fully deployed,
        // you can provide a Handler implementation to the the deployVerticle()
//        vertx.deployVerticle(new BasicVerticle(), stringAsyncResult -> {
//            System.out.println("BasicVerticle deployment complete");
//        });

        vertx.deployVerticle(new EventBusReceiverVerticle("R1"));
        vertx.deployVerticle(new EventBusReceiverVerticle("R2"));

        Thread.sleep(3000);
        vertx.deployVerticle(new EventBusSenderVerticle());
    }
}
