package thread;

public class ThreadEx04 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Counting Down" + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(10 - i + " ");
            }
            System.out.println("\nshot");
        });
        thread.start();
    }
}
