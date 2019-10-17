package CharacterArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class ByteArrayInputStreamEx02 {

    public static void main(String[] args) throws Exception{
        InputStream in  =new DataInputStream(new FileInputStream("file/A.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b = in.read();
        while (b !=-1){
            out.write(b);
            b = in.read();
        }
        byte[] data = out.toByteArray();
        for (byte d : data){
            System.out.println(d);
        }
    }

}
