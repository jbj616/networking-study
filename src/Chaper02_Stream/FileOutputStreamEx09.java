package Chaper02_Stream;

import javax.imageio.IIOException;
import java.io.FileInputStream;

public class FileOutputStreamEx09 {
    public static void main(String[] args) throws Exception{
        FileInputStream in = null;
        try{
            in = new FileInputStream("c:\\windows\\system.ini");

            int c;
            while((c = in.read())!= -1){
                System.out.print((char)c);

            }
            in.close();
        }catch (IIOException e){
            System.out.println("입출력 오류");
        }
    }
}
