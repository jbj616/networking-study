package thread_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureEx01 {
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = null;

        executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> {
            for (int i = 0; i < 500; i++) {
                FutureEx01.count++;
            }

            return FutureEx01.count;
        });
        System.out.println(future.get(10, TimeUnit.SECONDS));

        System.out.println("도달함.");

        executorService.shutdown();
    }
}
