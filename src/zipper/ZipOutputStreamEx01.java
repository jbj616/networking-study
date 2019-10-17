package zipper;

import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamEx01 {

    public static void main(String[] args) throws Exception{
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("file.zip"));
        zipOutputStream.setComment("Comment");
        zipOutputStream.setMethod(ZipOutputStream.STORED);
        //uncompressed("stored"): ZipOutputStream.STORED
        //compressed("deflated"): ZipOutputStream.DEFLATED

    }
}
