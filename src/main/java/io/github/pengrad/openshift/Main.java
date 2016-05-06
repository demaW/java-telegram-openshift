package io.github.pengrad.openshift;

import org.apache.log4j.Logger;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;

import static spark.Spark.*;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    private static final File FAVICON_PATH = new File("src/main/resources/favicon.ico");

    public static void main(String[] args) {
        ipAddress(args[0]);
        port(Integer.parseInt(args[1]));

        log.info("ip is: " + args[0]);

        get("/", (request, response) -> {
            response.status(200);
            log.info("in /");
            return "";
        });

        get("/favicon.ico", (request, response) -> {
                    response.status(200);
                    return " ";
                }
        );

        // Bot handler
        post("/myBot", new TestTelegramBot());

        // simple string by GET
        get("/hello", (req, res) -> "Hello World");

        // GET/POST handler
        post("/test", new Test());
        get("/test", new Test());
    }


    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) throws Exception {
            return "ok, test";
        }
    }
}
