package FilterStream;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputStreamEx02 {

//    두 개의 정수 18과 -18을 DataOutputStream의 writeInt() 메소드로 파일에 기록하고
//    FileInputStream의 read()를 사 용하여 1 바이트씩 읽어 그 내용을 출력한다

    public static void main(String[] args) throws Exception{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("file/1000.dat"));
        dos.writeInt(18);
        dos.writeInt(-18);
        dos.close();

        FileInputStream fis = new FileInputStream("file/1000.dat");
        int total = 0;
        int j=  fis.read();
        while (j!=-1){
            total++;
            System.out.print(j + " ");
            j = fis.read();
        }
        System.out.println(total + " bytes");
    }

}
