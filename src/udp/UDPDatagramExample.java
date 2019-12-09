package udp;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPDatagramExample {

    public static void main(String[] args) {
        String s = "This is a test";

        try{
            byte[] data = s.getBytes("UTF-8");

            InetAddress inetAddress = InetAddress.getByName("www.ibibio.org");
            int port = 7;

            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, port);
            System.out.println("이 패킷을 수신할 주소는 "+datagramPacket.getAddress()+", 포트는  "+datagramPacket.getPort());
            System.out.println("패킷의 길이는 "+ datagramPacket.getLength()+" 바이트");
            System.out.println("보낼 데이터는 "+new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), "UTF-8"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
