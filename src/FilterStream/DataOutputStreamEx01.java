package FilterStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DataOutputStreamEx01 {

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(new File("textFile.txt"));
        DataOutputStream out = new DataOutputStream(new FileOutputStream("binaryFile.txt"));

        while (input.hasNext()){
            int number = input.nextInt();
            out.writeInt(number);
        }
        out.close();
    }

}
