package thread_executor;

import java.util.Scanner;

public class CallbackUserInterface {

    private int number;
    private int result;

    public CallbackUserInterface(int number) {
        this.number = number;
    }

    public void calculateSum() {
        InstanceCallback instanceCallback = new InstanceCallback(number, this);
        Thread thread = new Thread(instanceCallback);
        thread.start();
    }

    public void receiveResult(int result) {
        this.result = result;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return number + "까지 수의 합 : " + result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수를 입력하세요 >> ");
        int num = scanner.nextInt();

        CallbackUserInterface caller = new CallbackUserInterface(num);
        caller.calculateSum();
    }
}
