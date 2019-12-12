package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastEx {

    public static void main(String[] args) {
        try{
            InetAddress group = InetAddress.getByName("experiment.mcast.net");
            byte[] data = "Here's some multicast data\r\n".getBytes();
            int port = 4000;
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, group, port);

            MulticastSocket ms = new MulticastSocket();
            ms.send(datagramPacket);
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
