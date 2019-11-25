import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class test {

    public static void main(String[] args) throws Exception{
        OutputStream outputStream = new FileOutputStream("A.txt");

        byte[] b1 = new byte[]{97, 98, 99, 100, 101};
        byte[] b2 = new byte[]{33, 34, 35};


    }

}
