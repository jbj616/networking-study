package Chaper02_Stream;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStream01 {
    public static void main(String[] args) throws Exception {
        File file = new File("myFile.txt");
        FileOutputStream fos = new FileOutputStream(file);

        for (int i = 65; i < 65 + 26; i++) {
            fos.write(i);
        }
        fos.close();
    }
}
