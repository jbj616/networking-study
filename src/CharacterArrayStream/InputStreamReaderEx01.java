package CharacterArrayStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderEx01 {

    public static void main(String[] args) throws Exception{
        int chars = 0;
        FileInputStream fis =new FileInputStream("file/hangeul.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
//        int input = isr.read();
//        while (input !=-1){
//            System.out.print((char)input);
//            chars++;
//            input = isr.read();
//        }
//        System.out.println("\n" + chars + " characters");
//        isr.close();
        String input = bufferedReader.readLine();
        while (input !=null){
            System.out.println(input);
            chars++;
            input = bufferedReader.readLine();
        }
        System.out.println("\n" + chars + " characters");
        bufferedReader.close();
    }

}
