package Chaper02_Stream;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamEx03 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream(new File("file321.dat"));
        int data = 321;

        fos.write(data);
        fos.close();
    }
}
