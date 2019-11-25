package URL;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionEx {

    public static void main(String[] args) throws IOException {
        URL u = new URL("http://www.hamsterdance.com");

        URLConnection uc = u.openConnection();
        InputStream in = uc.getInputStream();

        Reader r = new InputStreamReader(new BufferedInputStream(in));
        int c;
        while ((c= r.read())!=-1){
            System.out.print((char)c);
        }

    }
}
