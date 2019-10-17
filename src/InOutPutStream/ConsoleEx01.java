package InOutPutStream;

import java.io.IOException;

public class ConsoleEx01 {

    //몇 바이트로 이루어진 데이터를 1 바이트씩 콘솔로부터 읽 고 이를 다시 화면에 보이게 하는 프로그램을 작성하시오.
    //p 바이트를 문자로 해석하려면 cast를 사용해야 한다.

    public static void main(String[] args) throws IOException {
        int count = 0;
        int b = System.in.read();
        while (b !=-1){
            count++;
            System.out.println(b + " " + (char)b);
            b = System.in.read();
        }
        System.out.println("Number of Characters : "+count);
    }
}
