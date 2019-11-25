package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySimpleWebServer {

    public static void main(String[] args) throws  Exception{
        Socket socket = null;
        BufferedReader br = null;

        try{
            ServerSocket serverSocket = new ServerSocket(80);
            socket = serverSocket.accept();
            br  =new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = null;
            while ((line = br.readLine() )!=null){
                System.out.println(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(br!=null)
                br.close();
            if(socket!=null){
                socket.close();
            }
        }
    }

}
