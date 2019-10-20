package thread_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorEx04 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new ExecutorEx03());
        }
        executorService.shutdown();
    }
}
