package Chaper02_Stream;

import java.io.FileOutputStream;

public class FileOutputStreamEx04 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file02.dat");
        for (int i=321; i<321 + 26; i++){
            fos.write(i);
        }
        fos.close();
    }
}
