package URL;

import java.net.URLEncoder;

public class EncoderTest {

    public static void main(String[] args) throws Exception{
        System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
        System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
        System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));

    }
}
