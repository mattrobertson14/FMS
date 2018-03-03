package handlers;
import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;

public class FileHandler implements HttpHandler {

  @SuppressWarnings({"deprecation", "unchecked"})
  @Override
  public void handle(HttpExchange exchange) throws IOException {

    boolean success = false;

    try {

      String root = "../web";
      String path = exchange.getRequestURI().getPath();
      String requester = exchange.getRemoteAddress().getAddress().getHostAddress();
      String reqHostName = exchange.getRemoteAddress().getHostName();
      System.out.println(reqHostName + "(" + requester + ")" + " requested: " + path);
      File file;
      //System.out.println(root + exchange.getRequestURI().getPath());
      if (path.equals("") || path.equals("/")){
        file = new File(root + "/index.html");
        path = "/index.html";
      } else {
        file = new File(root + path);
      }

      if (file.isFile()) {
        Headers headers = exchange.getResponseHeaders();
        if (path.contains("css")){
          headers.set("Content-Type", "text/css");
        } else if (path.contains("ico")){
          headers.set("Content-Type", "image/x-icon");
        } else if (path.contains("js")){
          headers.set("Content-Type", "application/javascript");
        }  else {
          headers.set("Content-Type", "text/html");
        }
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        OutputStream respBody = exchange.getResponseBody();

        FileInputStream fs = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while ((count = fs.read(buffer)) >= 0) {
          respBody.write(buffer,0,count);
        }

        fs.close();
        respBody.close();

        success = true;
      }


      if (!success){
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);

        file = new File(root + "/HTML/404.html");
        OutputStream respBody = exchange.getResponseBody();

        FileInputStream fs = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while ((count = fs.read(buffer)) >= 0) {
          respBody.write(buffer,0,count);
        }

        fs.close();
        respBody.close();

        exchange.getResponseBody().close();
      }
    }

    catch (IOException e) {

			exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);

			exchange.getResponseBody().close();

			e.printStackTrace();
		}
  }


  /*private String readString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStreamReader sr = new InputStreamReader(is);
		char[] buf = new char[1024];
		int len;
		while ((len = sr.read(buf)) > 0) {
			sb.append(buf, 0, len);
		}
		return sb.toString();
	}*/
}
