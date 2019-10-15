package Chaper02_Stream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        File file = new File(args[0]);

        if(!file.exists())System.exit(0);
        if(!file.isDirectory())
            System.exit(0);
        File[] list = file.listFiles();
        for(File k : list){
            System.out.println(k.getName());
        }
    }
}
