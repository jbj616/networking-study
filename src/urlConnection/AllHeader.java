package urlConnection;

import java.net.URL;
import java.net.URLConnection;

public class AllHeader {


    public static void main(String[] args) throws Exception{

        URL u = new URL("https://www.github.com");
        URLConnection urlConnection = u.openConnection();

        for (int j=1; ; j++){
            String header = urlConnection.getHeaderField(j);
            if(header ==null) break;
            System.out.println(urlConnection.getHeaderFieldKey(j)+":"+header);
        }
    }
}
