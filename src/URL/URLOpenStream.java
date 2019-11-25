package URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLOpenStream {

    public static void main(String[] args) {
        try{
            URL u = new URL("http://www.naver.com");
            InputStream in = u.openStream();

            int c;
            while ((c = in.read())!=-1){
                System.out.write(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
