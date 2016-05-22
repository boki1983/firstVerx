package httpServer;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;

/**
 * Created by bernie on 2016/5/17.
 */
public class VertxHttpServerVerticle extends AbstractVerticle {

    private HttpServer httpServer = null;

    @Override
    public void start() throws Exception {
        // Creating an HTTP server is done using the Vertx instance method createHttpServer()
        httpServer = vertx.createHttpServer();

        // In order to handle incoming HTTP requests you must set a request handler on the HTTP server
//        httpServer.requestHandler(new Handler<HttpServerRequest>() {
//            @Override
//            public void handle(HttpServerRequest request) {
//                System.out.println("incoming request!");
//            }
//        });

        // Every time an HTTP request arrives at the HTTP server, the handle() method of the Handler object is called.
        // rewrote by lambda
        httpServer.requestHandler(httpServerRequest ->  {
            System.out.println("incoming request!");
            // access http header or parameters from HttpServerRequest obj
            System.out.println(httpServerRequest.uri());
            System.out.println(httpServerRequest.headers());
            System.out.println(httpServerRequest.path());


            /*If you want to wait until the full HTTP POST body has arrived
            you can attach an end handler instead.
            The end handler is not called until the full HTTP POST body has been received.
            However, the end handler does not have direct access to the full HTTP POST body.
            You need to collect that in the request handler.*/

            Buffer fullRequestBody = Buffer.buffer();
            // If the HTTP request is a HTTP POST request you need to handle it a bit differently.
            if (httpServerRequest.method() == HttpMethod.POST) {
                httpServerRequest.handler(buffer -> {
                    fullRequestBody.appendBuffer(buffer);
                });

                httpServerRequest.endHandler(buffer -> {
                   // here you can access the fullRequestBody Buffer instance.
                });
            }

            // send back an HTTP response for an incoming HTTP request.
            HttpServerResponse httpServerResponse = httpServerRequest.response();
            httpServerResponse.setStatusCode(200);
            httpServerResponse.headers()
                    .add("Content-Length", String.valueOf(57))
                    .add("Content-Type", "text/html");
            // write the response body back via the write() method
            httpServerResponse.write("Vert.x is alive!");
            httpServerResponse.end();
        });

        // Start httpServer using listen() method
        httpServer.listen(9999);


        // The close() method executes asynchronously
        //httpServer.close();
    }
}
