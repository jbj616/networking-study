package udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class UDPPoke {

    private int bufferSize;
    private DatagramSocket socket;
    private DatagramPacket packet;

    public UDPPoke(InetAddress host, int port, int bufferSize, int timeout) throws SocketException {
        packet = new DatagramPacket(new byte[1], 1, host, port);
        this.bufferSize = bufferSize;
        this.socket = new DatagramSocket(0);
        this.socket.connect(host, port);
        socket.setSoTimeout(timeout);
    }

    public UDPPoke(InetAddress host, int port, int bufferSize)throws SocketException{
        this(host, port, bufferSize, 30000);
    }

    public UDPPoke(InetAddress host, int port) throws SocketException{
        this(host, port, 8192, 30000);
    }

    public byte[] poke() throws IOException{
        byte[] response = null;

        try{
            socket.send(packet);
            DatagramPacket incoming = new DatagramPacket(new byte[bufferSize], bufferSize);

            socket.receive(incoming);
            int numBytes = incoming.getLength();

            response = Arrays.copyOf(incoming.getData(), numBytes);
        }catch (InterruptedIOException e){
            e.printStackTrace();
        }

        return response;

    }
}
