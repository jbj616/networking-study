package CharacterArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ByteArrayOutputStreamEx03 {
    //난수 발생기로 두 개의 double형 난수를 발생시켜 이를 ByteArrayOutputStream을 이용하여 바이트 배열로 변환하 고 여기서 생긴 바이트 배열의 내용을 doubles.txt라는 파 일에 출력하시오

    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i=0; i<2; i++){
            dataOutputStream.writeDouble(Math.random());
        }
        FileOutputStream fos = new FileOutputStream("file/double.txt");
        byteArrayOutputStream.writeTo(fos);
        fos.flush();
        fos.close();

    }

}
