package FilterStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamEx03 {

    public static void main(String[] args) throws Exception{
        FileOutputStream outFile = new FileOutputStream("file/line.dat");
        DataOutputStream dos = new DataOutputStream(outFile);
        dos.writeInt(12);
        dos.writeInt(32);

        try {
            FileInputStream file = new FileInputStream("file/line.dat");
            DataInputStream dis = new DataInputStream(file);
            String line = dis.readLine();
            while (line != null) {
                System.out.println(line);
                line = dis.readLine();
            }
            dis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
