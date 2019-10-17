package zipper;

import java.util.Enumeration;
import java.util.zip.ZipFile;

public class ZipLister {

    public static void main(String[] args) throws Exception{
        ZipFile zf = new ZipFile("my.zip");

        Enumeration enumeration = zf.entries();

        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }

}
