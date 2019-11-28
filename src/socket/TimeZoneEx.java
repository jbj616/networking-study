package socket;

import java.util.TimeZone;

public class TimeZoneEx {

    public static void main(String[] args) {
        TimeZone seoul = TimeZone.getTimeZone("Asiz/Seoul");
        TimeZone tokyo = TimeZone.getTimeZone("GMT-9");
        TimeZone kwangju = TimeZone.getDefault();

        System.out.println(seoul);
        System.out.println(tokyo);
        System.out.println(kwangju);
    }

}
