package thread;

public class ThreadEx02 extends Thread {

    String say;
    int delay;
    ThreadEx02(String whatToSay, int delayTime){
        say = whatToSay;
        delay = delayTime;
    }

    public void run(){
        try{
            for(;;){
                System.out.print(say+" ");
                sleep(delay);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) {
        new ThreadEx02("Quick", 333).start();
        new ThreadEx02("Slow", 1000).start();
    }

}
