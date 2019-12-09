package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDiscardServer {

    public static void main(String[] args) {

        byte[] buffer = new byte[65507];

        try{
            DatagramSocket socket = new DatagramSocket(9);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                try {
                    socket.receive(packet);
                    String s = new String(packet.getData(), 0, packet.getLength(), "8859_1");
                    System.out.println(packet.getAddress() + " at port " + packet.getPort() + " syas " + s);

                    packet.setLength(buffer.length);
                } catch (IOException e) {

                }
            }
        }catch (IOException e){

        }
    }

}
