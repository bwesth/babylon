package intranet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpServer;

public class Webserver {
    private static final int port = 8080;
    private static final int BACKLOG = 0;
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private HttpServer httpServer;
    private Responder responder;

    public static void main(String[] args) throws IOException {
      new Webserver(port);
    }
    
    public Webserver(int port) throws IOException {
        responder = new Responder();
        httpServer = HttpServer.create(new InetSocketAddress(port), BACKLOG);
        setupIO();
        importWebCode();
        httpServer.start();
        printServerInit();
        System.out.println("Server started in "+Timer.getInstance().ElapsedTime()+" seconds");
        System.out.println("Used memory: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024/1024));
    }
    
      /**
       * Creates context for importing favicon, javascript and css style files.
       */
      private void importWebCode() {
        httpServer.createContext("/",
            io -> responder.respond(io, 200, "text/html", getFile("web/login.html")));
        httpServer.createContext("/index",
            io -> responder.respond(io, 200, "text/html", getFile("web/index.html")));
        httpServer.createContext("/personalMenu",
            io -> responder.respond(io, 200, "text/html", getFile("web/personalMenu.html")));
        httpServer.createContext("/members",
            io -> responder.respond(io, 200, "text/html", getFile("web/members.html")));
        httpServer.createContext("/economics",
            io -> responder.respond(io, 200, "text/html", getFile("web/economics.html")));
        httpServer.createContext("/fav.ico",
            io -> responder.respond(io, 200, "image/x-icon", getFile("web/fav.ico")));
        httpServer.createContext("/code.js",
            io -> responder.respond(io, 200, "application/javascript", getFile("web/code.js")));
        httpServer.createContext("/intraStyle.css",
            io -> responder.respond(io, 200, "text/css", getFile("web/intraStyle.css")));
      }

      private void setupIO() {
        // httpServer.createContext("/search", io -> responder.search(io));
        httpServer.createContext("/login", io -> responder.login(io));
      }



      /**
       * Prints message after initialization including link to server site.
       */
      private void printServerInit() {
        String msg = " WebServer running on http://localhost:" + port + " ";
        System.out.println("╭" + "─".repeat(msg.length()) + "╮");
        System.out.println("│" + msg + "│");
        System.out.println("╰" + "─".repeat(msg.length()) + "╯");
      }
    
      /**
       * Takes the relatve path of a file to be returned as a byte array.
       * 
       * @param filename The relatve path of the file to be returned as a byte array.
       * @return A byte array containing the ASCII number of the chars in filename.
       */
      private byte[] getFile(String filename) {
        try {
          return Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
          e.printStackTrace();
          return new byte[0];
        }
      }
    
      /**
       * @return The CHARSET static final field.
       */
      protected static Charset getCharset() {
        return CHARSET;
      }
    
      /**
       * @return The HttpServer object.
       */
      protected HttpServer getHttpServer() {
        return httpServer;
      }
}
