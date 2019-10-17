package CharacterArrayStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx02 {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("file/alphabet.txt");
        for (int i=0; i<26; i++){
            fw.write(i+ 'a');

        }
        fw.close();
    }

}
