package Chaper02_Stream;

import java.io.FileOutputStream;

public class FileOutputStreamEx05 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file_191.dat");
        int dat = -191;
        fos.write(dat);
        fos.close();
        System.out.println("파일에 출력되는 값 = " + (-191 & 0xff));
    }
}
