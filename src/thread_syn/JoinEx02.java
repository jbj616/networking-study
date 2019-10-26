package thread_syn;

public class JoinEx02 extends Thread {

    private double average;

    public void run() {
        double result = 0;

        for (int i = 0; i < 10; i++) {
            result += Math.random();
        }

        average = result / 10;
    }

    public double getAverage() {
        return average;
    }

    public static void main(String[] args) {
        JoinEx02 thread = new JoinEx02();
        thread.start();
        doSomething();
        try {
            thread.join();
            System.out.println("result is " + thread.getAverage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("join 중에 Interrupt");
        }
    }

    public static void doSomething(){
        System.out.println("Hello");
    }
}

