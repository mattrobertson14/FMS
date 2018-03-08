package handlers;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import com.sun.net.httpserver.*;
import com.google.gson.Gson;

import service.RegisterService;
import regRes.RegisterRequest;
import regRes.RegisterResponse;

public class RegisterHandler implements HttpHandler{

  @SuppressWarnings({"deprecation", "unchecked"})
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    boolean success = false;
    try {
      InputStream reqBody = exchange.getRequestBody();
      String reqData = Utils.readString(reqBody);
      Gson gson = new Gson();
      HashMap<String, String> json = gson.fromJson(reqData, HashMap.class);

      checkString(json.get("userName"), "No Username provided");
      String username = json.get("userName");
      checkString(json.get("password"), "No Password provided");
      String password = json.get("password");
      checkString(json.get("email"), "No email provided");
      String email = json.get("email");
      checkString(json.get("firstName"), "No First Name provided");
      String firstName = json.get("firstName");
      checkString(json.get("lastName"), "No Last Name provided");
      String lastName = json.get("lastName");
      checkString(json.get("gender"), "No gender provided");
      String gender = json.get("gender");

      RegisterService service = new RegisterService();
      RegisterRequest request = new RegisterRequest(username, password, email, firstName, lastName, gender);
      RegisterResponse response = service.register(request);

      if (response == null){
        throw new BadRequestException("There is something incorrect");
      }

      exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
      OutputStream respBody = exchange.getResponseBody();
      String message = "{ \"authToken\": \"" +
                          response.getAuthToken() +
                          "\", \"userName\": \"" +
                          username +
                          "\", \"personId\": \"" +
                          response.getPersonId() + "\"}";
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

  public void checkString(String input, String message) throws BadRequestException {
    boolean res = true;
    if (input == null){
      res = false;
    }
    if (input.isEmpty()){
      res = false;
    }
    if (input.trim().length() == 0){
      res = false;
    }
    if (!res){
      throw new BadRequestException(message);
    }
  }

}
