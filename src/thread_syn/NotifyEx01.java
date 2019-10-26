package thread_syn;

import java.io.IOException;

public class NotifyEx01 {

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        Thread t1 = new Thread(waitNotify, "WAIT");
        Thread t2 = new Thread(waitNotify, "NOTIFY");
        t1.start();
        t2.start();
    }

}

class WaitNotify implements Runnable {

    private Object lockObject = new Object();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("WAIT")) {
            sun();
        }
        if (threadName.equals("NOTIFY")) {
            moon();
        }
    }

    private void sun() {
        synchronized (lockObject) {
            try {
                System.out.println("1 sun()");
                lockObject.wait();
                System.out.println("2 sun() ");
            } catch (InterruptedException e) {
                System.out.println("3 sun() ");
                e.printStackTrace();
            }
        }
    }

    private void moon(){
        synchronized (lockObject){
            System.out.println("A moon()");
            lockObject.notify();
            System.out.println("B moon()");

            try{
                int val = System.in.read();
                System.out.println(val);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}