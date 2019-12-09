package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoClient {

    public static void main(String[] args) throws IOException {
        String[] arg = {"localhost", "UTF-8","7"};
        byte[] bytesToSend = arg[1].getBytes();

        DatagramSocket socket = new DatagramSocket();

        socket.setSoTimeout(3000);

      //  DatagramPacket packet = new DatagramPacket(bytesToSend, )

    }

}
