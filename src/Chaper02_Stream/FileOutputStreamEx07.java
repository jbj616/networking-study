package Chaper02_Stream;

import java.io.FileOutputStream;

public class FileOutputStreamEx07 {
    public static void main(String[] args) throws Exception{
        String str = "전남대학교";
        FileOutputStream fos =new FileOutputStream("university.dat");
        fos.write(str.getBytes());
        fos.close();
    }
}
