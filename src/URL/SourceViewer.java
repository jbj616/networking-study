package URL;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class SourceViewer {

    public static void main(String[] args) {
        InputStream in = null;

        try{
            URL u = new URL("https://www.naver.com");
            in = u.openStream();

            in = new BufferedInputStream(in);
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read())!=-1){
                System.out.print((char)c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
