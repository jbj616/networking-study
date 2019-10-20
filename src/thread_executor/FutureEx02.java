package thread_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx02 {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(() -> {
            System.out.println("Asynchronous Callable");
            return "Callable Result";
        });
        System.out.println("future.get() = " + future.get());
        executorService.shutdown();
    }
}
