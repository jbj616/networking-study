package CharacterArrayStream;

import java.io.FileReader;
import java.io.LineNumberReader;

public class LineNumberReaderEx01 {

    public static void main(String[] args) throws Exception {
        String aLine;
        LineNumberReader br = new LineNumberReader(new FileReader("file/myFile.txt"));

        while ((aLine = br.readLine())!=null){
            System.out.println(br.getLineNumber()+ ": "+aLine);
        }

    }

}
