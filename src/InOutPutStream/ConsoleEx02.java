package InOutPutStream;

import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleEx02 {

    public static void main(String[] args) throws Exception{
        InputStream is = System.in;
        PrintStream ps = System.out;

        int total = 0;
        int j = is.read();
        while (j!=-1){
            total++;
            ps.println((char)j);
            j = is.read();
        }
        ps.print("\r\n"+total + " bytes");
    }

}
