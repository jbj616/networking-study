package zipper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZipper {

    public static void main(String[] args) throws Exception{
        ZipFile zipFile = new ZipFile("my.zip");
        Enumeration enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()){
            ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
            System.out.println("UnZipping : "+ zipEntry.getName());

            FileOutputStream fileOutputStream = new FileOutputStream(zipFile.getName());
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            for (int c = inputStream.read(); c!=-1; c = inputStream.read()){
                fileOutputStream.write(c);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }

}
