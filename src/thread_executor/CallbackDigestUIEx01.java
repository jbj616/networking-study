package thread_executor;

public class CallbackDigestUIEx01 {

    public static void receiveDigest(byte[] digest, String name){
        StringBuilder result = new StringBuilder(name);
        result.append(": ");
        for (byte tmp: digest){
            result.append(tmp);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String[] fileNames = {"file/digest.txt",  "file/university.dat"};

        for (String file: fileNames){
            CallbackEx01 callback = new CallbackEx01(file);
            Thread thread = new Thread(callback);
            thread.start();
        }

    }
}
