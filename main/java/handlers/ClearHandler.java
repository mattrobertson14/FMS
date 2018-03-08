package handlers;
import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;

import service.ClearService;
import regRes.ClearResponse;

public class ClearHandler implements HttpHandler{

  @SuppressWarnings({"deprecation", "unchecked"})
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    try {
      ClearService service = new ClearService();
      ClearResponse response = service.clear();

      if (!response.success){
        throw new BadRequestException(response.message);
      }

      exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
      OutputStream respBody = exchange.getResponseBody();
      String message = "{\"message\": \"" + response.message + "\"}";
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
