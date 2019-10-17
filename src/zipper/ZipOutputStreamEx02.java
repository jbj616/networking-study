package zipper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamEx02 {

    public static void main(String[] args) throws Exception{
        if(args.length < 2){
            System.out.println("Usage: java Zipper[ -d level] name.zip");
            return;
        }

        String outputFile = args[0];
        int level = 9;
        int start = 1;
        if(args[0].equals("-d")){
            try{
                level = Integer.parseInt(args[1]);
                outputFile = args[2];
                start = 3;
            }catch (Exception e){
                System.out.println("Usage: java Zipper [-d level] name.zip");
                return;
            }

        }

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        zipOutputStream.setLevel(level);
        for (int i= start; i<args.length; i++){
            ZipEntry zipEntry = new ZipEntry(args[i]);
            FileInputStream fileInputStream = new FileInputStream(args[i]);
            try{
                System.out.println("Compressing"+ args[i]);
                zipOutputStream.putNextEntry(zipEntry);
                for (int c = fileInputStream.read(); c != -1; c = fileInputStream.read()){
                    zipOutputStream.write(c);
                }
            }finally {
                fileInputStream.close();
            }
        }
        zipOutputStream.close();
    }

}
