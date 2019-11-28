package serverSocket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    public static int PORT = 13;

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket connection = server.accept();
                System.out.println(connection.toString());
                threadPool.submit(new Echo(connection));
            }
        } catch (IOException e) {
            System.out.println("에러 발생!");
        }
    }
}

class Echo implements Runnable {

    private Socket connection;

    Echo(Socket connection) {
        this.connection = connection;
    }

    public void run() {

        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String str = reader.readLine();
                str = Thread.currentThread().getName() + ": " + str;

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
                writer.println(str);
                writer.flush();

            }
        } catch (IOException e) {
            System.out.println("에러 발생!!");
        }


    }

}