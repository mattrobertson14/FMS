package handlers;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import com.sun.net.httpserver.*;
import com.google.gson.Gson;

import service.LoginService;
import regRes.LoginRequest;
import regRes.LoginResponse;

public class LoginHandler implements HttpHandler{

  @SuppressWarnings({"deprecation", "unchecked"})
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    try {
      // Get Request Body JSON and convert it to a <String, String> map
      InputStream reqBody = exchange.getRequestBody();
      String reqData = Utils.readString(reqBody);
      Gson gson = new Gson();
      HashMap<String, String> json = gson.fromJson(reqData, HashMap.class);

      // Set variables to pass as attributes to objects
      if (json.get("userName") == null || json.get("userName").isEmpty() || json.get("userName").trim().length() == 0){
        throw new BadRequestException("No Username Provided");
      }
      String username = json.get("userName");

      if (json.get("password") == null || json.get("password").isEmpty() || json.get("password").trim().length() == 0){
        throw new BadRequestException("No Password Provided");
      }
      String password = json.get("password");

      // Use LoginService to attempt to log user in
      LoginService service = new LoginService();
      LoginRequest request = new LoginRequest(username, password);
      LoginResponse response = service.login(request);

      if (response == null){
        throw new BadRequestException("Username or Password Incorrect");
      }

      exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
      OutputStream respBody = exchange.getResponseBody();
      String message = "{ \"authToken\": \"" +
                          response.getAuthToken() +
                          "\", \"userName\": \"" +
                          username + "\"}";
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
