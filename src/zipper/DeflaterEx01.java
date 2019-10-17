package zipper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;

public class DeflaterEx01 {

    public static void main(String[] args) throws Exception{
        FileInputStream fin = new FileInputStream("file/allnames");
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(new FileOutputStream("file/allnames.dfl"));

        for (int c = fin.read(); c!=-1; c= fin.read()){
            deflaterOutputStream.write(c);
        }
        deflaterOutputStream.close();
        fin.close();
    }

}
