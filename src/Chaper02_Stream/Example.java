package Chaper02_Stream;

import java.io.File;

public class Example {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        File f = new File("..\\dirC");
        System.out.println("getName() = " + f.getName());
        System.out.println("getPath() = " + f.getPath());
        System.out.println("getAbsolutePath() = " + f.getAbsolutePath());
        System.out.println("getParent() = " + f.getPath());

    }
}
