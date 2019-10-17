package CharacterArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class ByteArrayInputStreamEx03 {

    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos);

        String s = "자바Stream";
        osw.write(s);
        osw.flush();
        byte[] byteArray = bos.toByteArray();

        for (int m = 0; m<byteArray.length; m++){
            System.out.print(byteArray[m]+ " ");
            int ich = byteArray[m] & 0xff;
            System.out.println(Integer.toHexString(ich)+" ");
        }
        String reconstructed = new String(byteArray, 0, byteArray.length);
        System.out.println('\n'+ reconstructed);
    }

}
