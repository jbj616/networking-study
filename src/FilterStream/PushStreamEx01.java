package FilterStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public class PushStreamEx01 {

    public static void main(String[] args) throws Exception{
        OutputStream out = new FileOutputStream("A.txt");
        for (int data = 'A'; data <='Z'; data++){
            out.write(data);
        }
        out.close();
        PushbackInputStream pis = new PushbackInputStream(new FileInputStream("A.txt"), 10);
        byte[] b1 = new byte[]{97, 98, 99, 100, 101}; //a, b, c, d, e
        byte[] b2 = new byte[]{33, 34, 35}; // #, ", !
        int count = 0;
        int m = pis.read();
        while (m!=-1){
            count++;
            System.out.println((char)m);
            if(count == 2){
                for (int i=0; i<b1.length ;i++){
                    pis.unread(b1[i] & 0xff);
                }
                pis.unread(b2);
            }
            m = pis.read();
        }
    }

}
