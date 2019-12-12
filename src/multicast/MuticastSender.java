package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class MuticastSender {

    public static void main(String[] args) throws Exception {

        InetAddress host = InetAddress.getByName("237.100.100.1");
        int port = 1900;

        MulticastSocket ms = new MulticastSocket();
        ms.setTimeToLive(64);
        ms.joinGroup(host);
        for(int i=0; i<10; i++){
            byte[] data = (i+ " " +new Date() + "멀티 캐스터 데이터 \r\n").getBytes("UTF-8");
            DatagramPacket packet = new DatagramPacket(data, data.length, host, port);
            ms.send(packet);
        }

        ms.leaveGroup(host);

    }
}
