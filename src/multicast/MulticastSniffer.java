package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.file.Path;

public class MulticastSniffer{

    public static void main(String[] args) throws Exception{
        InetAddress group = InetAddress.getByName("239.255.255.250");
        int port = 1900;

        MulticastSocket ms = new MulticastSocket(port);
        ms.joinGroup(group);

        while (true) {
            byte[] buffer = new byte[8192];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            ms.receive(packet);
            String s = new String(packet.getData(), "UTF-8");
            System.out.println(s);
        }

    }
}
