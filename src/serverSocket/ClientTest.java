package serverSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ClientTest {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(80, 1);
            System.out.println("Listening for connections on port "
                                   + server.getLocalPort());
            while (true) {
                Socket connection = server.accept();
                try {
                    System.out.println("Connection established with "
                                           + connection);
                    Thread input = new InputThread(connection.getInputStream());
                    input.start();
                    Thread output = new OutputThread(connection.getOutputStream());
                    output.start();
                    try {
                        input.join();
                        output.join();
                    } catch (InterruptedException ex) {
                        System.err.println(ex);
                    }

                } catch (IOException ex) {
                    System.err.println(ex);
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class InputThread extends Thread {

    InputStream in;

    public InputThread(InputStream in) {
        System.out.println(314);
        this.in = in;
    }

    public void run() {
        try {
            int i = in.read();
            while (i != -1) {
                System.out.write(i);
                i = in.read();
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
// output thread closed the
        } catch (IOException ex) {
            System.err.println(ex);
        }
        try {
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class OutputThread extends Thread {

    private Writer out;

    public OutputThread(OutputStream out) {
        System.out.println(3221);
        this.out = new OutputStreamWriter(out);
    }

    public void run() {
        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = in.readLine();
            System.out.println(line);
            while (!(line.equals("."))) {
                out.write(line + "\r\n");
                out.flush();
                line = in.readLine();

            }
        } catch (IOException ex) {
        }
        try {
            out.close();
        } catch (IOException ex) {
        }
    }
}