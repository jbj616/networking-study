package thread;

public class ThreadEx01 extends Thread {

    public void run(){
        for (int i=0; i<10; i++){
            System.out.println("Counting: "+ (i+1));
        }
    }

    public static void main(String[] args) {
        new ThreadEx01().start();
    }

}
