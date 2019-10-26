package thread_syn;

public class WaitNotifyAverage {

    public static void main(String[] args) {
        Mean average = new Mean();
        Thread t1 = new Thread(new Waiter(average), "waiter");
        Thread t2 = new Thread(new Server(average, new int[]{1, 2, 3, 4, 5}), "server");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}

class Waiter implements Runnable {

    private Mean average;

    public Waiter(Mean average) {
        this.average = average;
    }

    @Override
    public void run() {
        synchronized (average) {
            try {
                average.wait();
                System.out.println("average = " + average.getAverage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Server implements Runnable {

    private Mean average;
    private int[] array;

    Server(Mean average, int[] array) {
        this.average = average;
        this.array = array;
    }

    @Override
    public void run() {
        synchronized (average) {
            double sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            average.setAverage(sum / array.length);
            average.notify();
        }
    }
}

class Mean {

    private double average;

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return this.average;
    }
}