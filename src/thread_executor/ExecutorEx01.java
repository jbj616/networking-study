package thread_executor;

public class ExecutorEx01 {

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            unitTask();
        }
    }

    private static void unitTask(){
        System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
    }
}
