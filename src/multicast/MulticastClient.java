package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

    MulticastSocket receiver = null;
    DatagramPacket packet = null;
    InetAddress multicastGroup = null;
    int port = 1900;
    String address = "237.100.100.1";
    byte[] b = new byte[100];

    public MulticastClient() throws Exception {
        receiver = new MulticastSocket(port);
        multicastGroup = InetAddress.getByName(address);
        packet = new DatagramPacket(b, b.length);
        receiver.joinGroup(multicastGroup);

        for (int i = 0; i < 3; i++) {
            receiver.receive(packet);
            String notice = new String(packet.getData(), 0,packet.getLength(), "UTF-8");
            System.out.println(notice);
        }
        receiver.leaveGroup(multicastGroup);
        receiver.close();
    }

    public static void main(String[] args) throws  Exception{
        new MulticastClient();
    }
}
