package thread_syn;

public class NotifyEx02 {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(new Wait(lock), "WAIT");
        Thread t2 = new Thread(new Notify(lock), "NOTIFY");
        t1.start();
        t2.start();
    }

}

class Wait implements Runnable {

    private Object lockObject;

    public Wait(Object lockObject) {
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        synchronized (lockObject) {
            try {
                System.out.println(Thread.currentThread().getName() + " - 1");
                lockObject.wait();
                System.out.println(Thread.currentThread().getName() + " - 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("sun() 3");
            }
        }
    }
}

class Notify implements Runnable {

    private Object lockObject;

    Notify(Object lockObject) {
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        synchronized (lockObject) {
            System.out.println(Thread.currentThread().getName() + " - A");
            lockObject.notify();
            System.out.println(Thread.currentThread().getName() + " - B");

        }
    }
}