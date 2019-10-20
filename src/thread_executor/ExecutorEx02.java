package thread_executor;

public class ExecutorEx02 implements Runnable {
    @Override
    public void run() {
        unitTask();
    }

    private void unitTask(){
        System.out.println(Thread.currentThread().getName() + " 1회 일 처리");
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            new Thread(new ExecutorEx02()).start();
        }
    }
}
