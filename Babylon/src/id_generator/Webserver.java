package id_generator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpServer;

/**
 *  The webserver class is responsible for setting up the webserver.
 */

public class Webserver {
  private static final int PORT = 8010;
  private static final int BACKLOG = 0;
  private static final Charset CHARSET = StandardCharsets.UTF_8;
  private HttpServer httpServer;
  private Database database;

  /**
   * Creates a <code>WebSever</code> object where the search engine can run
   * @param port  The port for the locally hosted <code>WebSever</code>
   * @throws IOException
   */
  public Webserver(int port) throws IOException {
    database = new Database();
    httpServer = HttpServer.create(new InetSocketAddress(port), BACKLOG);
    setupIO();
    importWebCode();
    httpServer.start();
    printServerInit();
  }

  /**
   * 
   */
  private void setupIO(){
    httpServer.createContext("/", io -> database.respond(io, 200, "text/html", getFile("Babylon/web/index.html")));
    httpServer.createContext("/send", io -> database.addMember(io));
  }

  /**
   * 
   */
  private void importWebCode() {
    // httpServer.createContext("/favicon.ico",
    //     io -> searchEngine.respond(io, 200, "image/x-icon", getFile("web/favicon.ico")));
    httpServer.createContext("/code.js",
        io -> database.respond(io, 200, "application/javascript", getFile("Babylon/web/code.js")));
    // httpServer.createContext("/style.css", io -> database.respond(io, 200, "text/css", getFile("style.css")));
  }

  /**
   * 
   */
  private void printServerInit() {
    String msg = " WebServer running on http://localhost:" + PORT + " ";
    System.out.println("╭" + "─".repeat(msg.length()) + "╮");
    System.out.println("│" + msg + "│");
    System.out.println("╰" + "─".repeat(msg.length()) + "╯");
  }

  /**
   * 
   * @param filename
   * @return  
   */
  public byte[] getFile(String filename) {
    try {
      return Files.readAllBytes(Paths.get(filename));
    } catch (IOException e) {
      e.printStackTrace();
      return new byte[0];
    }
  }



  /**
   * Benchmark method
   * @return  The <code>PORT</code> static final field
   */
  //For benchmarking purposes we need to get the searchEngine object.


  //Why static? -mids
  public static int getPort() {
    return PORT;
  }

  /**
   * @return  The <code>CHARSET</code> static final field
   */
  //Why static? -mids
  public static Charset getCharset() {
    return CHARSET;
  }

  /**
   * @return  The <code>HttpServer</code> object
   */
  public HttpServer getHttpServer() {
    return httpServer;
  }

  public Database getDatabase(){
      return database;
  }
}