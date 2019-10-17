package Digest;

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;

public class DigestEx01 {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.jnu.ac.kr");
        InputStream inputStream = url.openStream();
        MessageDigest sha = MessageDigest.getInstance("SHA");
        byte[] data = new byte[1024];
        while (true) {
            int bytesRead = inputStream.read(data);
            if (bytesRead < 0) {
                break;
            }
            sha.update(data, 0, bytesRead);
        }
        byte[] result = sha.digest();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
