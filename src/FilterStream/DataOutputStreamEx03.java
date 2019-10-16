package FilterStream;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputStreamEx03 {

    //위의프로그램에서18대신65*224 +66*216 +67*28 + 68을,
    // -18대신60*224 +61*216 +62*28 +63을writeInt() 로 기록하여 그 결과를 텍스트 편집기로 확인하시오.

    public static void main(String[] args) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("file/ABCD.dat"));

        int a = 65 * pow(2, 24) + 66 * pow(2, 16) + 67 * pow(2, 8) + 68;
        System.out.println(a);
        dos.writeInt(a);
        int b = 0x3C * pow(2, 24) + 0x3D * pow(2, 16) + 0x3E * pow(2, 8) + 0x3F;
        dos.writeInt(b);
        dos.close();
        FileInputStream fis = new FileInputStream("file/ABCD.dat");
        int total = 0;
        int j = fis.read();
        while (j != -1) {
            total++;
            System.out.print(j + " ");
            j = fis.read();
        }
        System.out.println(total + " bytes");
    }

    public static int pow(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
