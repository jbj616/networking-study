package thread;

public class ThreadEx06 {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread = new Thread(worker, "Able");
        thread.start();
        for (int i=0; i<3; i++)
            worker.namePrint();
    }

}
class Worker implements Runnable{

    Worker(){
        Thread maker = Thread.currentThread();
        System.out.println(maker + "has created" + this);
    }


    @Override
    public void run() {
        for (int i=0; i<3; i++){
            namePrint();
        }
    }

    public void namePrint(){
        Thread thread = Thread.currentThread();
        System.out.println("namePrint() called by "+ thread.getName());
    }
}