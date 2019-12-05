package serverSocket;

import java.io.IOException;
import java.net.ServerSocket;

public class RandomPort {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(0);
            System.out.println("This is server runs on por " +serverSocket.getLocalPort());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
