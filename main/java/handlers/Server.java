package handlers;
import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;

import dao.Database;

public class Server {
  private static final int MAX_WAITING_CONNECTIONS = 12;

  private HttpServer server;

  private void run(String portNumber){

    System.out.print("Initializing HTTP Server...");

    try {
      server = HttpServer.create(
        new InetSocketAddress(Integer.parseInt(portNumber)),
        MAX_WAITING_CONNECTIONS);
    }
    catch(IOException e) {
      e.printStackTrace();
      return;
    }

    System.out.println(" Done.\n");

    server.setExecutor(null);

    System.out.println("Creating contexts\n");
    //server.createContext("/user/", new UserHandler());

    server.createContext("/", new FileHandler());

    server.createContext("/user/login", new LoginHandler());

    server.createContext("/user/register", new RegisterHandler());

    server.createContext("/clear", new ClearHandler());

    server.createContext("/person", new PersonHandler());

    server.createContext("/event", new EventHandler());

    System.out.print("Starting server... ");

    server.start();

    System.out.println("Started Succesfully!\n\nNow Running on Port " + portNumber + "\n");
  }


  public static void main(String[] args) {
    String portNumber = args[0];
    new Server().run(portNumber);
  }
}
