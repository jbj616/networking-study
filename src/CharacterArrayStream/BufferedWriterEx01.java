package CharacterArrayStream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterEx01 {

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("file/alphabet.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < 26; i++) {
            bw.write(i + 'a');
        }

        bw.close();
    }

}
