package CharacterArrayStream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputWriterEx01 {

    public static void main(String[] args) throws Exception{
        FileOutputStream fos =new FileOutputStream("file/hangeul.txt");
        OutputStreamWriter w = new OutputStreamWriter(fos, "MS949");
        w.write("자바의 outputstream wirter 스트림 사용 연습");
        w.close();
    }

}
