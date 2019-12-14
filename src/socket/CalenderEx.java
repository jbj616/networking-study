package socket;

import java.util.Calendar;
import java.util.TimeZone;

public class CalenderEx {

    public static void main(String[] args) {
        Calendar calender = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        calender.setTimeZone(timeZone);

        int year = calender.get(Calendar.YEAR);
        int month = calender.get(Calendar.MONTH)+1;
        int date = calender.get(Calendar.DATE);
        int amPm = calender.get(Calendar.AM_PM);
        int hour = calender.get(Calendar.HOUR);
        int min = calender.get(Calendar.MINUTE);
        int sec = calender.get(Calendar.SECOND);

        String ap = amPm == Calendar.AM? "AM" : "PM";
        System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초", year, month, date, ap, hour, min, sec);
    }

}
