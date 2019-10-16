package FilterStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx01 {

    public static void main(String[] args) throws IOException {
        int num;

        DataInputStream in = new DataInputStream(new FileInputStream("file/binaryFile.txt"));
        System.out.println("The first 6 integers in binaryFile ar : \n");
        for (int i=1; i<=6; i++){
            num = in.readInt();
            System.out.println(num);
        }
    }

}
