package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

class UDPPokerServer {

    public static void main(String[] args) {

        try{
            DatagramSocket socket = new DatagramSocket(13);
            while (true){
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);
                    socket.receive(request);

                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("US-ASCII");
                    DatagramPacket response = new DatagramPacket(data, data.length, request.getAddress(),
                                                                 request.getPort());
                    socket.send(response);
                    System.out.println(daytime);

                }catch (IOException e){

                }
            }


        }catch (IOException e){

        }
    }

}
