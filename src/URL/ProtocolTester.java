package URL;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTester {

    public static void main(String[] args) {
        testProtocol("https://www.adc.org");

        testProtocol("https://www.amazon.com");

        testProtocol("mailto:elharo@ibiblio.org");

        testProtocol("file:///etc/passwd");

    }

    private static void testProtocol(String url){
        try{
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
