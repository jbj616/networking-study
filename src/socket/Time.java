package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Time {

    private static final String HOSTNAME = "localhost";

    public static void main(String[] args) throws IOException, ParseException{
        Date d = Time.getDateFromNetWork();
        System.out.println("It is "+d);
    }

    public static Date getDateFromNetWork() throws  IOException, ParseException{
        TimeZone gmt = TimeZone.getTimeZone("GMT");
        Calendar epoch1900 = Calendar.getInstance(gmt);
        epoch1900.set(1900, 01, 01, 00, 00, 00);
        long epoch1900ms = epoch1900.getTime().getTime();

        Calendar epoch1970 = Calendar.getInstance(gmt);
        epoch1970.set(1970, 01, 01, 00, 00, 00);
        long epoch1970ms = epoch1970.getTime().getTime();

        long differenceInMs = epoch1970ms - epoch1900ms;
        long differenceBetweenEpochs = differenceInMs/1000;
        System.out.println(differenceInMs);

        Socket socket = null;
        try{
            socket = new Socket(HOSTNAME, 37);
            socket.setSoTimeout(15000);

            InputStream in = socket.getInputStream();

            long secondsSint1900 = 0;
            for (int i=0; i<4; i++){
                secondsSint1900 = (secondsSint1900<<8)|in.read();
            }

            long secondsSince1970 = secondsSint1900 - differenceBetweenEpochs;

            long msSince1970 = secondsSince1970 * 1000;
            Date time = new Date(msSince1970);

            return time;
        }finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
}
