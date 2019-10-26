package thread_syn;

public class NotifyEx03 {

    public static void main(String[] args) {

    }

}
class WaitNotify2 implements Runnable{

    private Object lockObect = new Object();
    private boolean OK = false;

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("WAIT"))
            sun();
        if(Thread.currentThread().getName().equals("NOTIFY"))
            moon();
    }

    private void sun(){
        synchronized (lockObect){
            try {
                System.out.println(Thread.currentThread().getName() + " - 1");
                while(OK !=true){
                    lockObect.wait();
                }
                System.out.println(Thread.currentThread().getName() + " - 2");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void moon(){
        synchronized (lockObect){
            System.out.println(Thread.currentThread().getName() + " - A");
            OK = true;
            lockObect.notify();
            System.out.println(Thread.currentThread().getName() + " - B");
        }
    }
}