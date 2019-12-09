package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DaytimeUDPClient {

    public static void main(String[] args) {

        try{
            DatagramSocket socket = new DatagramSocket(0);
            socket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, 13);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);

            socket.send(request);
            socket.receive(response);
            String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
