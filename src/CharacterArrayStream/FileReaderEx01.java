package CharacterArrayStream;

import java.io.FileReader;

public class FileReaderEx01 {

    public static void main(String[] args) throws Exception {
        int chars = 0;
        FileReader fileReader = new FileReader("file/hangeul.txt");
        int input = fileReader.read();
        while (input != -1) {
            System.out.print((char) input);
            chars++;
            input = fileReader.read();
        }
        System.out.println("\n" + chars + " characters");
        fileReader.close();
    }

}
