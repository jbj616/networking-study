package Chaper02_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputStreamEx03 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("a.png");
        FileOutputStream fos = new FileOutputStream("b.png");
        int total = 0;
        int j = fis.read();
        while (j!= -1){
            total++;
            fos.write(j);
            j = fis.read();
        }
        System.out.println(total + "bytes");
    }
}
