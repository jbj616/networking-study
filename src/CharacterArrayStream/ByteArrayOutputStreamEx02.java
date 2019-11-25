package CharacterArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;

public class ByteArrayOutputStreamEx02 {
    //난수 발생기로 두 개의 double형 난수를 발생시켜 이를 ByteArrayOutputStream으로 출력하고 여기서 생긴 바이트 배열의 내용을 화면에 인쇄하시오.

    public static void main(String[] args) throws Exception {

        URL u = new URL("www.naver.com");
        InputStream in = u.openStream();

        MessageDigest md = MessageDigest.getInstance("SHA");

        byte[] count = new byte[100];
        int tmp = 0;
        while (true){
            tmp = in.read(count);

            if(tmp < 0){
                break;
            }

            md.update(count, 0, tmp);
        }
        byte[] shaa = md.digest();

    }

}
