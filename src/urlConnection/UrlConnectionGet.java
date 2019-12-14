package urlConnection;

import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionGet {

    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.naver.com");

        URLConnection connection = url.openConnection();

        System.out.println("getContentType: " + connection.getContentType());
    }

}
