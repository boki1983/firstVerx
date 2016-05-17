package vertx;

import io.vertx.core.AbstractVerticle;

/**
 * Created by bernie on 2016/5/10.
 */
public class BasicVerticle extends AbstractVerticle {

    // The start() method is called by Vert.x when the verticle is deployed and ready to start.
    @Override
    public void start() throws Exception {
        System.out.println("BasicVerticle started");
    }

    // The stop() method is called when Vert.x shuts down and your verticle needs to stop.
    @Override
    public void stop() throws Exception {
        System.out.println("BasicVerticle stopped");
    }
}
