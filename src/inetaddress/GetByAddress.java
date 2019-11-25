package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddress {

    public static void main(String[] args) {
        try{
            byte[] address = {107, 23, (byte)216, (byte)196};
            InetAddress lessWrong = InetAddress.getByAddress(address);
            InetAddress lessWrongWithName = InetAddress.getByAddress("lessWrong.com", address);

            System.out.println(lessWrong);
            System.out.println(lessWrongWithName);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
