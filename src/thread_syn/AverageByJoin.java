package thread_syn;

public class AverageByJoin {

    public static void main(String[] args) {

        Average average = new Average();
        Thread calc = new Thread(new Calculator(average));
        Thread add = new Thread(new AddMachine(average, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));

        calc.start();
        add.start();
        try{
            add.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
class Calculator implements Runnable{

    private Average average;

    Calculator(Average average) {
        this.average = average;
    }

    @Override
    public void run() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "평균은 "+ average.getAverage()+" 입니다.";
    }
}
class AddMachine implements Runnable {

    private Average average;
    private int[] array;

    AddMachine(Average average, int[] array) {
        this.average = average;
        this.array = array;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        average.setAverage(sum / array.length);
    }
}

class Average {

    private int average;

    public void setAverage(int average) {
        this.average = average;
    }

    public int getAverage() {
        return average;
    }
}