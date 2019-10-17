package zipper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;

public class GZIPEx01 {

    public static void main(String[] args) throws Exception{
        GZIPInputStream gzin = new GZIPInputStream(new FileInputStream("allnames.gz"));
        FileOutputStream fileOutputStream = new FileOutputStream("allnames");
        int b = gzin.read();
        while (b!=-1){
            fileOutputStream.write(b);
            b = gzin.read();
        }
        gzin.close();
        fileOutputStream.close();
    }

}
