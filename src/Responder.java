
import java.io.IOException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class Responder {
    private Database database;

    public Responder() throws IOException {
        database = new Database();
    }

    // public void search(HttpExchange io) {
    //     Timer.getInstance().StartTimer();
    //     String searchTerm = io.getRequestURI().getRawQuery().split("=")[1];
    //     ArrayList<String> response = queryHandler.handleQuery(searchTerm);
    //     byte[] bytes = response.toString().getBytes(Webserver.getCharset());
    //     respond(io, 200, "application/json", bytes);
    //     System.out.println(Timer.getInstance().ElapsedTime());
    // }
    
    public void login(HttpExchange io) {
        String[] input = io.getRequestURI().getRawQuery().split("=");
        String username = input[1];
        String password = input[3];

        boolean credentials = database.isAdministration();
        respond(io, 200, "application/json", credentials);
    }

    protected void respond(HttpExchange io, int code, String mime, byte[] response) {
        try {
            io.getResponseHeaders().set("Content-Type",
                    String.format("%s; charset=%s", mime, Webserver.getCharset().name()));
            io.sendResponseHeaders(200, response.length);
            io.getResponseBody().write(response);
        } catch (Exception e) {
            System.out.println("io response failed. Check connection status or .html / .js corruption");
        } finally {
            io.close();
        }
    }

    protected void respond(HttpExchange io, int code, String mime, boolean response) {
        try {
            io.getResponseHeaders().set("Content-Type",
                    String.format("%s; charset=%s", mime, Webserver.getCharset().name()));
            io.sendResponseHeaders(200, 1);
            io.getResponseBody().write(1);
                } catch (Exception e) {
            System.out.println("io response failed. Check connection status or .html / .js corruption");
        } finally {
            io.close();
        }
    }
}