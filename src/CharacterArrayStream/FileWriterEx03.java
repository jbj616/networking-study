package CharacterArrayStream;

import java.io.FileWriter;

public class FileWriterEx03 {

    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("file/hangeul.txt");
        String s = "자바의 FileWriter를 사용한다.";
        fw.write(s);
        fw.flush();
        fw.close();
    }

}
