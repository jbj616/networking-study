package CharacterArrayStream;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamEx01 {

    public static void main(String[] args) throws Exception {

        byte[] fromArray = {1, 2, 3, 4, 5};
        System.out.println("배열 내의 byte 수 " + fromArray.length);
        ByteArrayInputStream bais = new ByteArrayInputStream(fromArray);
        byte[] carrier = new byte[512];
        int count = bais.read(carrier);
        while (count != -1) {
            System.out.println(count);
            System.out.println(":)");
            System.out.write(carrier, 0, count);
            count = bais.read(carrier);
        }
        System.out.println("byte 배열을 모디터에 모두 출력했음.");
    }

}
