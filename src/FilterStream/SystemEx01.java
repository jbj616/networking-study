package FilterStream;

public class SystemEx01 {

    public static void main(String[] args) throws Exception{
        int count = 0;
        int b = System.in.read();

        while (b !=-1){
            System.out.println("hello");
            count+=1;
            System.out.println(b + " " + (char)b);
            b = System.in.read();
        }
        System.out.println("Number of Characters: "+count);
    }

}
