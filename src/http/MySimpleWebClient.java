package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class MySimpleWebClient {

    public static void main(String[] args) throws Exception {
        Writer out = null;
        BufferedReader bufferedReader = null;
        Socket socket = null;

        socket = new Socket("localhost", 80);
        out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");

        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        out.write("GET / HTTP/1.0\r\n\r\n");
        out.flush();

        int count = 0;
        int ch = bufferedReader.read();
        while (ch != -1 && count < 1000) {
            System.out.print((char) ch);
            count++;
            ch = bufferedReader.read();
        }

    }

}
