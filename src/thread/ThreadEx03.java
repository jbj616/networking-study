package thread;

public class ThreadEx03 implements Runnable {

    @Override
    public void run() {
        System.out.print("Counting Down"+ " ");
        for(int i=0; i<10; i++){
            System.out.print(10-i + " ");
        }
        System.out.println("\nShot");
    }

    public static void main(String[] args) {
        new Thread(new ThreadEx03()).start();
    }
}
