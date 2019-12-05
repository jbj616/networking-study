package serverSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleFileHTTPServer {

    private final byte[] content;
    private final byte[] header;
    private final int port;
    private final String encoding;

    public SingleFileHTTPServer(String data, String encoding, String mimeType, int port)
        throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, mimeType, port);
    }

    public SingleFileHTTPServer(byte[] data, String encoding, String mimeType, int port) {
        this.content = data;
        this.port = port;
        this.encoding = encoding;
        String header = "HTTP/1.0 200 OK\r\n"
                            + "Server: OnFile 2.0\r\n"
                            + "Content-length: " + this.content.length + "\r\n"
                            + "Content-Type: " + mimeType + "; charset=" + encoding + "\r\n\r\n";
        this.header = header.getBytes(Charset.forName("US-ASCII"));
    }

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(this.port)) {

            while (true){
                try {
                    Socket connection = serverSocket.accept();
                    pool.submit(new HTTPHandler(connection));
                }catch (Exception e){

                }
            }
        } catch (IOException e) {

        }
    }
    private class HTTPHandler implements Callable<Void>{

        private Socket connection;

        HTTPHandler(Socket connection){
            this.connection = connection;
        }

        @Override
        public Void call() throws Exception {
            try{
                OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                InputStream in = new BufferedInputStream(connection.getInputStream());

                StringBuilder request = new StringBuilder(80);
                while (true){
                    int c = in.read();
                    if(c =='\r'|| c =='\n' || c == -1){
                        break;
                    }
                    request.append((char)c);
                }
                if(request.toString().indexOf("HTTP/")!=-1){
                    out.write(header);
                }
                out.write(content);
                out.flush();
            }catch (Exception e){

            }finally {
                connection.close();
            }
            return null;
        }
    }
    public static void main(String[] args) {
        int port = 80;
        String encoding = "UTF-8";

        try{
            Path path = Paths.get("./index.html");
            byte[] data = Files.readAllBytes(path);

            String contentType = URLConnection.getFileNameMap().getContentTypeFor("./index.html");
            SingleFileHTTPServer server = new SingleFileHTTPServer(data, encoding, contentType, port);
            server.start();
        }catch (Exception e){

        }
    }
}
