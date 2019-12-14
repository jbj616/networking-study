package udp;

import java.net.InetAddress;

public class UDPPokeTimeClient {

    public static void main(String[] args) {
        try {
            UDPPoke poker = new UDPPoke(InetAddress.getByName("localhost"), 13);

            byte[] response = poker.poke();

            System.out.println(new String(response,0,  response.length, "US-ASCII"));

        }catch (Exception e){

        }
    }

}
