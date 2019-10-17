package CharacterArrayStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterEx02 {
    //문자 스트림을 이용하여 파일로부터 읽어 들여 문자 스트 림을 이용하여 파일에 출력한다

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    public PrintWriterEx02() throws FileNotFoundException, IOException{
        String inputFile = "file/inputfile";
        String outputFile = "file/outputfile";

        bufferedReader = new BufferedReader(new FileReader(inputFile));
        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

    }
    public static void main(String[] args) throws Exception{
        PrintWriterEx02 printWriterEx02 = new PrintWriterEx02();

        String str;
        int lineCount = 0;
        while ((str = printWriterEx02.bufferedReader.readLine()) != null) {

            lineCount++;
            printWriterEx02.printWriter.println(lineCount + ": "+str);
            System.out.println(lineCount+" process");
        }
        printWriterEx02.printWriter.close();
    }

}
