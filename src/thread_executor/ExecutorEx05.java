package thread_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorEx05 {
    private static void uniTask(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<100; i++){
            executorService.execute(()->{
                uniTask();
            });
        }

        executorService.shutdown();
    }
}
