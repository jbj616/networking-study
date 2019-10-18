package thread;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class ThreadEx05 implements Runnable{

    private String fileName;

    public ThreadEx05(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try{
            FileInputStream fileInputStream= new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, sha);
            while (digestInputStream.read()!=-1);
            digestInputStream.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder(fileName);
            result.append(": ");
            for (byte byt : digest){
                result.append(byt);
            }
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (String filName : args){
            ThreadEx05 threadEx05 = new ThreadEx05(filName);
            Thread thread = new Thread(threadEx05);
            thread.start();
        }
    }
}
