package handlers;
import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import com.google.gson.Gson;

import service.PersonService;
import regRes.PersonRequest;
import regRes.PersonResponse;

public class PersonHandler implements HttpHandler{

  @SuppressWarnings({"deprecation", "unchecked"})
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    try {
      String path = exchange.getRequestURI().getPath();
      String id = null;
      PersonRequest request;
      PersonService service = new PersonService();
      Gson gson = new Gson();

      if (path.equals("/person") || path.equals("/person/")){
        request = new PersonRequest();
      } else {
        id = path.substring(8,path.length());
        request = new PersonRequest(id);
      }

      PersonResponse response = service.person(request);

      if (response.getMessage() != null){
        throw new BadRequestException(response.getMessage());
      }

      exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
      OutputStream respBody = exchange.getResponseBody();
      String message = gson.toJson(response, PersonResponse.class);
      Utils.writeString(message, respBody);
      respBody.close();
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
