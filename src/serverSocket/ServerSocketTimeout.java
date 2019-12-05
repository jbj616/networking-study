package serverSocket;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTimeout {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(2048);
            serverSocket.setSoTimeout(3000);

            try{
                Socket socket = serverSocket.accept();
            }catch (InterruptedIOException e){

            }finally {
                serverSocket.close();
            }
        }catch (IOException e){

        }
    }

}
