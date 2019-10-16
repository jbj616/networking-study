package FilterStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class BuffedStreamEx02 {

    public static void main(String[] args) throws Exception {
        long start = new Date().getTime();
        FileOutputStream fos = new FileOutputStream("numbers.dat");
        for (int i = 0; i < 100000; i++) {
            fos.write(i);
        }

        fos.close();

        int bytes = 0;
        FileInputStream fis = new FileInputStream("numbers.dat");
        int input = fis.read();
        while (input != -1) {
            bytes++;
            input = fis.read();
        }
        System.out.println("Tot = " + bytes);
        fis.close();
        long end = new Date().getTime();

        System.out.println("ElapsedTime = " + (end - start));
    }

}
