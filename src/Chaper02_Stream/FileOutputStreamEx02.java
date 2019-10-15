package Chaper02_Stream;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamEx02 {
    public static void main(String[] args) throws Exception{
        File file = new File("file02.dat");
        FileOutputStream fos = new FileOutputStream(file);

        for (int i=33; i<126 ; i++){
            fos.write(i);
        }
        fos.close();
    }
}
