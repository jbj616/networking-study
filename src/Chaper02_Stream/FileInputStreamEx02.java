package Chaper02_Stream;

import java.io.FileInputStream;

public class FileInputStreamEx02 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("a.txt");
        int total = 0;
        int j;
        while (true){
            if((j =fis.read())==-1) break;
            total++;
        }
        System.out.println(total+ "bytes");
    }
}
