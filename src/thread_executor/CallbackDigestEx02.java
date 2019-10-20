package thread_executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CallbackDigestEx02 implements Runnable {

    private String filename;
    private CallbackDigestUIEx02 callback;


    public CallbackDigestEx02(String filename, CallbackDigestUIEx02 callback){
        this.filename = filename;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != -1) ;  // read entire file
            din.close();
            byte[] digest = sha.digest();
            callback.receiveDigest(digest);
        } catch (IOException | NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }

    }
}
