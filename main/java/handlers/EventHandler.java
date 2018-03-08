package handlers;
import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import com.google.gson.Gson;

import service.EventService;
import regRes.EventRequest;
import regRes.EventResponse;

public class EventHandler implements HttpHandler{

  @SuppressWarnings({"deprecation", "unchecked"})
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    try {
      Headers reqHeaders = exchange.getRequestHeaders();

      if (reqHeaders.containsKey("Authorization")){

        String authToken = reqHeaders.getFirst("Authorization");
        String path = exchange.getRequestURI().getPath();
        String id = null;
        EventRequest request;
        EventService service = new EventService();
        Gson gson = new Gson();

        if (path.equals("/event") || path.equals("/event/")){
          request = new EventRequest();
          request.setAuthToken(authToken);
        } else {
          id = path.substring(7,path.length());
          request = new EventRequest(id);
          request.setAuthToken(authToken);
        }

        EventResponse response = service.event(request);

        if (response.getMessage() != null){
          throw new BadRequestException(response.getMessage());
        }

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        OutputStream respBody = exchange.getResponseBody();
        String message = gson.toJson(response, EventResponse.class);
        Utils.writeString(message, respBody);
        respBody.close();
      }
    }
    catch (IOException e) {
      exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
      exchange.getResponseBody().close();
      e.printStackTrace();
    }
    catch (BadRequestException e){
      exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
      OutputStream respBody = exchange.getResponseBody();
      String message = "{ \"message\": \"" + e.getMessage() + "\" }";
      Utils.writeString(message, respBody);
      respBody.close();
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
