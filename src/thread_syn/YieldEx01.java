package thread_syn;

public class YieldEx01 extends Thread{

    static int times;
    static boolean doYeild;
    private String word;

    YieldEx01(String word){
        this.word = word;
    }

    public void run(){
        for (int i=0; i<times; i++){
            System.out.println(word);
            if(doYeild) yield(); //give another thread a chance
        }
    }

    public static void main(String[] args) {
        String[] tmpArgs = {"false", "3", "did", "didnot"}; //withdout yielding
        //String[] tmpArgs = {"true", "3", "today", "yesterday", "tomorrow"}; //yield


        times = Integer.parseInt(tmpArgs[1]);
        doYeild = new Boolean(tmpArgs[0]).booleanValue();
        Thread currentThread = currentThread();
        currentThread.setPriority(Thread.MAX_PRIORITY);

        for (int i=2; i< tmpArgs.length; i++){
            new YieldEx01(tmpArgs[i]).start();
        }
    }

}
