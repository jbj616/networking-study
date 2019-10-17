package CharacterArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class ByteArrayOutputStreamEx02 {
    //난수 발생기로 두 개의 double형 난수를 발생시켜 이를 ByteArrayOutputStream으로 출력하고 여기서 생긴 바이트 배열의 내용을 화면에 인쇄하시오.

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for(int r = 0; r<2; r++){
            dataOutputStream.writeDouble(Math.random());
        }

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        for (int r = 0; r<byteArray.length; r++){
            System.out.print((byteArray[r]&0xff)+" ");
        }
    }

}
