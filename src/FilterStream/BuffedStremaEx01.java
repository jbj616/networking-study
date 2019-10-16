package FilterStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class BuffedStremaEx01 {
//    0부터 시작하는 100000개의 정수를 파일에 출력 후
//    다시 열어서 전체의 데이터를 읽는 프로그램

    public static void main(String[] args) throws Exception {
        int from = 0;
        int to = 100000;
        long start = new Date().getTime();
        FileOutputStream fos = new FileOutputStream(("numbers.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (int i = 0; i < 100000; i++) {
            bos.write(i);
        }

        bos.flush();
        bos.close();

        int bytes = 0;
        FileInputStream fis = new FileInputStream("numbers.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int input = bis.read();
        while (input != -1) {
            bytes++;
            input = bis.read();
        }
        bis.close();
        System.out.println("Tot = " + bytes);
        long end = new Date().getTime();
        System.out.println("Buffed Elapsed Time = " + (end - start));

    }

}
