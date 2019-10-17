package Digest;

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;

public class DigestEx03 {

    public static void main(String[] args) throws Exception{
        URL source = new URL("https://naver.com");
        URL mirror = new URL("https://google.com");
        byte[] sourceDigest = getDigestFromURL(source);
        byte[] mirrorDigest = getDigestFromURL(mirror);

        if(MessageDigest.isEqual(sourceDigest, mirrorDigest)){
            System.out.println("Same");
        }else{
            System.out.println("needs to be updated");
        }
    }

    public static byte[] getDigestFromURL(URL u) throws Exception{

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        InputStream inputStream = u.openStream();
        byte[] data = new byte[128];
        while (true){
            int bytesRead = inputStream.read(data);
            if(bytesRead<0){
                break;
            }
            messageDigest.update(data, 0, bytesRead);
        }
        return messageDigest.digest();
    }
}
