package thread_syn;

public class JoinEx01 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("hello");

        });

        thread.start();

        try {
            thread.join();
            System.out.println("thread finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
