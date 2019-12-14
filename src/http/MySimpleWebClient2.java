package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;

public class MySimpleWebClient2 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getByName("www.jnu.ac.kr"), 80);

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            out.write("GET / HTTP1.1 \r\n\r\n");
            out.flush();

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (IOException e) {

        }
    }

}
