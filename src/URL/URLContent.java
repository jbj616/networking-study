package URL;

import java.io.IOException;
import java.net.URL;

public class URLContent {

    public static void main(String[] args) throws IOException {
        URL u = new URL("https://naver.com");
        Object o = u.getContent();
        System.out.println("I got a " + o.getClass().getName());
    }

}
