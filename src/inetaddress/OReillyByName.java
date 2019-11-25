package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class OReillyByName {

    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName("www.jnu.ac.kr");
            System.out.println(address);

            InetAddress address_host = InetAddress.getByName("168.131.31.206");
            System.out.println(address_host.getHostName());

            InetAddress[] addresses = InetAddress.getAllByName("www.apple.com");
            System.out.println(Arrays.toString(addresses));
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
