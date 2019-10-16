package FilterStream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx02 {

    //DataInputStream의 readInt()를 이용하여 앞의 예에서 만 든 1000.dat를 읽어 들이시오.

    public static void main(String[] args) {
        int total = 0;
        try{
            DataInputStream dis = new DataInputStream(new FileInputStream("file/1000.dat"));
            while (true) {
                int theRead = dis.readInt();
                total++;
                System.out.print(theRead+ " ");
            }
        }catch (EOFException e){
            System.out.println(total + "ints reads");
        }catch (IOException e){
            System.out.println("Some IO Exception");
        }
    }

}
