package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by bernie on 2016/5/10.
 */
//create Verticle by extending AbstractVerticle
public class MyVerticle extends AbstractVerticle {
    /*A verticle has a start() and a stop() method which are called
    when the verticle is deployed and when it is undeployed.*/

    // This Future can be used to asynchronously tell Vert.x if the Verticle was deployed successfully.
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        System.out.println("MyVerticle started!");
    }


    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        System.out.println("MyVerticle stopped!");
    }

}
