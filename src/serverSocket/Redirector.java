package serverSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Redirector {

    private final int port = 80;
    private final String newSite = "https://naver.com";

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    Thread t = new RedirectThread(socket);
                    t.start();
                } catch (IOException e) {

                }
            }
        } catch (BindException e) {

        } catch (IOException e) {

        }
    }

    private class RedirectThread extends Thread {

        private final Socket connection;

        RedirectThread(Socket connection) {
            this.connection = connection;
        }

        public void run() {
            try {
                Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuilder request = new StringBuilder(80);
                while (true) {
                    int c = in.read();
                    if (c == '\r' || c == '\n' || c == -1) {
                        break;
                    }
                    request.append((char) c);
                }

                String get = request.toString();
                String[] pieces = get.split("\\w*");
                String theFile = pieces[1];
                if (get.indexOf("HTTP") != -1) {
                    out.write("HTTP/1.0 302 FOUND\r\n");
                    Date now = new Date();
                    out.write("Date: " + now + "\r\n");
                    out.write("Server: Redirector 1.1\r\n");
                    out.write("Location: " + newSite + theFile + "\r\n");
                    out.write("Content-type: text/html\r\n\r\n");
                    out.flush();
                }

                out.write("<HTML><HEAD><TITLE>Document moved</TITLE ></HEAD >\r\n ");
                out.write(" < BODY ><H1 > Document moved</H1 >\r\n ");
                out.write(" The document " + theFile
                              + " has moved to\r\n<A HREF=\"" + newSite + theFile + "\">" + newSite + theFile
                              + "</A>.\r\n Please update your bookmarks<P>");
                out.write("</BODY></HTML>\r\n");
                out.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public static void main(String[] args) {

        Redirector redirector = new Redirector();
        redirector.start();
    }
}