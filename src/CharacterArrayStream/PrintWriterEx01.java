package CharacterArrayStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterEx01 {

    public static void main(String[] args) throws Exception{
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("file/alphabet.txt")));
        for (int i=0; i<26; i++){
            pw.println((char)(i+'A'));
        }
        pw.close();
    }

}
