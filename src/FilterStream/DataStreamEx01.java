package FilterStream;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEx01 {

    public static void main(String[] args) throws Exception {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("file/real.dat"));
        for (int i = 0; i < 5; i++) {
            dos.writeDouble(Math.random());
        }
        dos.flush();
        dos.close();

        int total = 0;
        try {
            FileInputStream fis = new FileInputStream("file/real.dat");
            int j = fis.read();
            while (j != -1) {
                total++;
                System.out.print(j + " ");
                if (total % 8 == 0) {
                    System.out.print("\n");

                }
                j = fis.read();

            }
            fis.close();
            System.out.println(total + "bytes");
        }catch (IOException e){
            e.printStackTrace();
        }

         total = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("file/real.dat"));
            while (true) {
                double theRead = dis.readDouble();
                total++;
                System.out.println(theRead + " ");
            }
        }catch (EOFException e){
            System.out.println(total + "Doubles");
        }


    }
}
