package httpServer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;

/**
 * Created by boki on 5/22/16.
 */
public class VertxHttpClientVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        HttpClient httpClient = vertx.createHttpClient();
        // send a GET request using its getNow() method

        // The Handler implementation passed to the getNow() method is called
        // when the headers of the HTTP response are received
        httpClient.getNow(80, "tutorials.jenkov.com", "/", httpClientResponse ->  {
            System.out.println("Response received");

            /*if you do need to access the body of the HTTP response,
            you need to register another handler on the HttpClientResponse
            that is passed as parameter to the first Handler's handle() method.*/
            httpClientResponse.bodyHandler( buffer -> {
                System.out.println("Response (" + buffer.length() + "): ");
                System.out.println(buffer.getString(0, buffer.length()));
            });
        });
    }
}
