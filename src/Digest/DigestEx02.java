package Digest;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestEx02 {

    public static void main(String[] args)throws IOException, NoSuchAlgorithmException {
        URL url = new URL("https://www.naver.com");
        InputStream inputStream = url.openStream();
        MessageDigest sha = MessageDigest.getInstance("SHA");
        byte[] data = new byte[128];
        while (true){
            int bytesRead = inputStream.read(data);
            if(bytesRead<0)
                break;
            sha.update(data, 0, bytesRead);
        }
        byte[] result = sha.digest();
        for (int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
        System.out.println(new BigInteger(result));
    }

}
