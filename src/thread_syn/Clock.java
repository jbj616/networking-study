package thread_syn;

public class Clock {

    public static void main(String[] args) {
        Switch minute_second = new Switch();
        Switch hour_minute = new Switch();
        Second second = new Second(minute_second);
        Minute minute = new Minute(minute_second, hour_minute);
        Hour hour = new Hour(hour_minute);

        Thread t1 = new Thread(second);
        Thread t2 = new Thread(minute);
        Thread t3 = new Thread(hour);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Hour implements Runnable {

    private int hour = 0;
    private Switch hour_minute;

    Hour(Switch hour_minute) {
        this.hour_minute = hour_minute;
    }

    @Override
    public void run() {
        while (true) {
            hour_minute.on();
            if (hour == 23) {
                hour = 0;
            } else {
                hour++;
                System.out.println(this);
            }
        }
    }

    @Override
    public String toString() {
        return "hour : " + hour + " minute : 0 second : 0";
    }
}

class Second implements Runnable {

    private int seconds = 0;
    private Switch minute_second;

    public Second(Switch minute_second) {
        this.minute_second = minute_second;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (seconds == 59) {
                minute_second.off();
                seconds = 0;
            } else {
                seconds++;
                System.out.println(this);
            }
        }
    }

    @Override
    public String toString() {
        return "seconds : " + seconds;
    }
}

class Minute implements Runnable {

    private int minutes = 0;
    private Switch minute_second;
    private Switch hour_minute;

    Minute(Switch minute_second, Switch hour_minute) {
        this.minute_second = minute_second;
        this.hour_minute = hour_minute;
    }

    @Override
    public void run() {
        while (true) {
            minute_second.on();
            if (minutes == 59) {
                hour_minute.off();
                minutes = 0;

            } else {
                minutes++;
                System.out.println(this);
            }
        }
    }

    @Override
    public String toString() {
        return "minutes : " + minutes + " second : 0";
    }
}

class Switch {

    private boolean inUse = true;

    public synchronized void on() {
        while (inUse) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        inUse = true;
    }

    public synchronized void off() {
        inUse = false;
        notify();
    }
}
