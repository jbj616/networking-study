package zipper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipperEx01 {

    public static void main(String[] args) throws Exception{

        for (int i=0; i<args.length; i++){
            FileInputStream fileInputStream = new FileInputStream(args[i]);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ZipEntry zipEntry = null;

            while ((zipEntry = zipInputStream.getNextEntry())!= null){
                FileOutputStream fileOutputStream = new FileOutputStream(zipEntry.getName());
                for (int c = zipInputStream.read(); c!=-1; c = zipInputStream.read()){
                    fileOutputStream.write(c);
                }
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
            zipInputStream.closeEntry();
        }
    }

}
