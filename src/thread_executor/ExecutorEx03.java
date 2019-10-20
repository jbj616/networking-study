package thread_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorEx03 implements Runnable {

    private static Executor executor = Executors.newSingleThreadExecutor();

    public void run() {
        uniTask();
    }

    private void uniTask() {
        System.out.println(Thread.currentThread().getName() + " 1회 실행");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executor.execute(new ExecutorEx03());
        }

    }
}
