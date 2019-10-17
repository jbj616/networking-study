package CharacterArrayStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx01 {

    public static void main(String[] args) throws IOException {
        File file = new File("file/myfile.txt");
        FileWriter fw = new FileWriter(file);

        char ch = 'a';
        fw.write(ch);
        fw.flush();
        fw.close();
    }

}
