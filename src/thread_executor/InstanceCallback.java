package thread_executor;

public class InstanceCallback implements Runnable {

    private int number;
    private CallbackUserInterface callback;

    public InstanceCallback(int number, CallbackUserInterface callback) {
        this.number = number;
        this.callback = callback;
    }

    @Override
    public void run() {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += i;
        }
        callback.receiveResult(result);
    }
}
