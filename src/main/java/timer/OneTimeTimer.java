package timer;

import io.vertx.core.AbstractVerticle;

/**
 * Created by boki on 5/22/16.
 */
public class OneTimeTimer extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        // one-time timer is a timer that fires a single time after a specified delay.

        /*setTimer() method takes a time interval in milliseconds as first parameter,
        and a Handler implementation as second parameter.*/
        long timerID = vertx.setTimer(3000, aLong -> {
            System.out.println("Timer fired : " + aLong);
        });
    }
}
