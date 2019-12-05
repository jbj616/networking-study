package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LowPortScanner {

    public static void main(String[] args) throws Exception{

        String host = "localhost";
        InetAddress fddi =InetAddress.getByName("fddisunsite.oit.unc.edu");
        int tmp = -1;

        for (int i = 1; i < 1024; i++) {

            try {
                Socket socket = new Socket(host, i, fddi, 0);
                tmp = i;
                System.out.println("There is a server on port" + i + " of " + host);
                socket.close();
            } catch (UnknownHostException e) {
                break;
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        System.out.println(tmp);
    }

}
