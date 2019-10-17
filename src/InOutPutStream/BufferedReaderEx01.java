package InOutPutStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderEx01 {

    public static void main(String[] args) throws Exception{
        int c;
        int count = 0;
        InputStreamReader link = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(link);
        while ((c = br.read()) != -1) {
            count++;
            System.out.println(c + " " + (char) c);
        }
        System.out.println(count);
    }

}
