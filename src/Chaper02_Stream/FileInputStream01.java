package Chaper02_Stream;

import java.io.FileInputStream;

public class FileInputStream01 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("myFile.txt");
        int k;
        while ((k=fis.read())!=-1){
            System.out.print((char)k);
        }

         fis = new FileInputStream("myFile.txt");
        while (true){
            int d = fis.read();
            if(d == -1)
                break;
            System.out.print(d);
        }
    }
}
