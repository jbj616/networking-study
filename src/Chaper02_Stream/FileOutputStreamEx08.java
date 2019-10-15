package Chaper02_Stream;

import java.io.FileInputStream;

public class FileOutputStreamEx08 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("myFile.txt");
        int total = 0;
        int j= fis.read();
        while (j != -1){
            total++;
            j= fis.read();
        }

        System.out.println(total + "bytes");
    }
}
