package udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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

            System.arraycopy(incoming.getData(), 0, response, 0, numBytes);
        }catch (InterruptedIOException e){

        }

        return response;
    }

    public static void main(String[] args) {
        InetAddress host = null;
        int port = 0;

        try{
            host = InetAddress.getByName("localhost");
            port = 13;
        }catch (Exception e){

        }

        try{
            UDPPoke poke = new UDPPoke(host, port);
            byte[] response = poke.poke();
            if(response == null){
                System.out.println("no response");
                return;
            }

            String result = "";
            try{
                result = new String(response, "UTF-8");
            }catch (UnsupportedEncodingException e){
                result = new String(response, "8859_1")   ;
            }
            System.out.println(result);
        }catch (Exception e){

        }


    }
}
