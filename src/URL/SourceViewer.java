package URL;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class SourceViewer {

    public static void main(String[] args) {
        InputStream in = null;

        try {
            URL u = new URL("https://www.naver.com");
            in = u.openStream();

            Reader reader = new InputStreamReader(new BufferedInputStream(in));
            int c = reader.read();
            while ((c = reader.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
