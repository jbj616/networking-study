package Chaper02_Stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class FileInputStreamEx06 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("a.png");
        BufferedInputStream bis = new BufferedInputStream(fis);

        int j;
        for (int i=0; i<3; i++){
            j = bis.read();
            System.out.println(j);
        }
        System.out.println("Mark here!");
        bis.mark(3);

        for (int i=0; i<5; i++){
            j = bis.read();
            System.out.println(j);
        }
        System.out.println("Reset");
        bis.reset();

        for (int i=0; i<10; i++){
            j = bis.read();
            System.out.println(j);
        }
    }
}
