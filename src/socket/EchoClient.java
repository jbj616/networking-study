package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws Exception{

        PrintWriter writer = null;
        BufferedReader reader = null;

        Socket socket = new Socket("localhost", 7);

        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(socket.getOutputStream());

        while (true){

            String str = reader.readLine();

            if(str.equals(".")){
                break;
            }

            writer.println(str);
            writer.flush();

            BufferedReader reader_2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader_2.readLine());

        }

    }
}
