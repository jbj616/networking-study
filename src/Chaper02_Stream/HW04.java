package Chaper02_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HW04 {
    public static void main(String[] args) throws Exception{
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6,7, 8, 10};
        int result = Calculator.sumLength(arr1, arr2);
        System.out.println("짝수의 개수는 : " + result);
    }
}
class Calculator {

    public static int sumLength(int[] arr1, int[] arr2) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        EvenGenerator task1 = new EvenGenerator(arr1);
        EvenGenerator task2 = new EvenGenerator(arr2);

        Future<Integer[]> future1 = executorService.submit(task1);
        Future<Integer[]> future2 = executorService.submit(task2);

        return future1.get().length + future2.get().length;
    }
}

class EvenGenerator implements Callable<Integer[]>{

    private int[] arr;

    EvenGenerator(int[] arr){
       this.arr = arr;
    }

    @Override
    public Integer[] call() throws Exception {
        List<Integer> list = new ArrayList<>();

        for (int element : arr){
            if(element%2==0){
                list.add(element);
            }
        }

        return list.toArray(new Integer[list.size()]);
    }
}