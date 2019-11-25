package Digest;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.MessageDigest;

public class DigestEx04 {

    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.naver.com");
        FileOutputStream fileOutputStream = new FileOutputStream("file/digest.txt");
        copyFileWithDigest(url.openStream(), fileOutputStream);
        fileOutputStream.close();
    }

    public static void copyFileWithDigest(InputStream in, OutputStream out) throws Exception{
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        DigestOutputStream dout = new DigestOutputStream(out, sha);
        byte[] data = new byte[128];

        while (true){
            int bytesRead = in.read(data);
            if(bytesRead<0)
                break;

            dout.write(data, 0, bytesRead);
        }
        dout.flush();

        System.out.println("htlleo");
        byte[] result = dout.getMessageDigest().digest();
        for (int i=0; i<result.length; i++){
            System.out.println(result[i]+" ");
        }
        System.out.println();
    }

}
