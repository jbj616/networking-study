package CharacterArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class ByteArrayOutputStreamEx01 {

    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        String s = "자바Stream";
        outputStreamWriter.write(s);
        outputStreamWriter.flush();
        System.out.println(byteArrayOutputStream);

    }

}
