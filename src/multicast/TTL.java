package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TTL {
    public static void main(String[] args) throws Exception {
        InetAddress group = InetAddress.getByName("experiment.mcast.net");
        byte[] data = "Here's some multicast data\r\n".getBytes();
        int port = 4000;
        DatagramPacket packet = new DatagramPacket(data, data.length, group, port);
        MulticastSocket socket = new MulticastSocket();
        socket.setTimeToLive(64);
        socket.send(packet);
    }
}
