package timer;

import io.vertx.core.AbstractVerticle;

/**
 * Created by boki on 5/22/16.
 */
public class PeriodicTimers extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        // periodic timer is a timer that fires every time a specified period of time has passed.
        /*setPeriodic() method takes a time interval in milliseconds as first parameter,
        and a Handler implementation as second parameter.*/
        long timerID = vertx.setPeriodic(3000, aLong -> {
            System.out.println("Timer 1 fired: " + aLong);
        });
    }
}
