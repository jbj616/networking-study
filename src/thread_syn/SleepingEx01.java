package thread_syn;

public class SleepingEx01 {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true){
                System.out.println("hello");

                try{
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        });
        thread.start();
        thread.interrupt();
    }

}
