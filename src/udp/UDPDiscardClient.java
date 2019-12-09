package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDiscardClient {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 9;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(host);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = input.readLine();
                if (line.equals(".")) {
                    break;
                }

                byte[] data = line.getBytes();
                DatagramPacket output = new DatagramPacket(data, data.length, address, port);
                socket.send(output);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
