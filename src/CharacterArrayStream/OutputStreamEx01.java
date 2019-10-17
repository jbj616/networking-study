package CharacterArrayStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamEx01 {

    public static void main(String[] args) throws Exception{
        OutputStream os =new FileOutputStream("file/hanguel.txt");
        byte[] data = "자바stream".getBytes("UTF-16");
        for (int m = 0; m <data.length; m++){
            int ich = data[m] & 0xff;
            os.write(ich);
        }
    }

}
