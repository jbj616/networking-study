package Chaper02_Stream;

import java.io.FileInputStream;

public class FileInputStreamEx04 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("a.png");
        int total = 0;
        byte[] temp = new byte[100];
        int count = fis.read(temp);
        while (count!=-1){
            total = total+count;
            System.out.write(temp, 0, count);
            count = fis.read(temp);
        }
        System.out.println(total+" bytes");
    }
}
