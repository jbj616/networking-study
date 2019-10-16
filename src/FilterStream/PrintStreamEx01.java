package FilterStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx01 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("textout.txt");
        PrintStream ps = new PrintStream(fos);
        boolean bool = true;
        ps.println(bool);
        byte b = -128;
        ps.println(b);
        double d = 0.9;
        ps.println(d);
        ps.write(127);
        Object o = new Object();
        ps.println(o);


    }

}
