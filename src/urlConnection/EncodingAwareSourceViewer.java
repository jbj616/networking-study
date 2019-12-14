package urlConnection;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class EncodingAwareSourceViewer {

    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.naver.com");
        URLConnection connection = url.openConnection();

        String contentType = connection.getContentType();
        String encoding ="utf-8";
        int encodingStart = contentType.indexOf("charset=");
        if(encodingStart !=-1){
            encoding = contentType.substring(encodingStart+8);
        }

        Reader r = new InputStreamReader(new BufferedInputStream(connection.getInputStream()), encoding);

        int c;
        while ((c = r.read())!=-1){
            System.out.print((char)c);
        }

        System.out.println(connection.getContentLength());
    }

}
