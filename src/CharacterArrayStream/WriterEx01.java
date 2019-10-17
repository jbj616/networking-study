package CharacterArrayStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriterEx01 {

    public static void main(String[] args) throws Exception{
        OutputStream os = new FileOutputStream("file/hangeul.dat");
        int h = '한';
        int b1 = h/256;
        int b2 = h%256;
        os.write(b1);
        os.write(b2);
    }

}
