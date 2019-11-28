package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Daytime {

    public String getDateFromNetWork() throws IOException, ParseException{
        try(Socket socket = new Socket("localhost", 13)){
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder sb = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c!=-1; c = reader.read()){
                sb.append((char)c);
            }
            return sb.toString();
        }
    }

    static Date parseDate(String s)throws ParseException{
        String[] pieces = s.split("");
//        String dateTime = pieces[1] + " "+ pieces[2] + " UTC";
//        DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
//        return format.parse(dateTime);
        System.out.println(Arrays.toString(pieces));
        return new Date();
    }

    public static void main(String[] args) throws Exception{
        Daytime daytime = new Daytime();
        System.out.println(daytime.getDateFromNetWork());
    }
}
