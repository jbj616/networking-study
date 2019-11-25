package URL;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class URLDownload {

    public static void main(String[] args) {
        try{
            URL u = new URL("file:///D:...");
            Reader r = new InputStreamReader(new BufferedInputStream(u.openStream()));

            int c;
            while ((c = r.read())!=-1){
                System.out.print((char)c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
