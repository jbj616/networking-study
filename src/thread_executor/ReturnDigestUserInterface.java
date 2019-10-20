package thread_executor;

public class ReturnDigestUserInterface {

    public static void main(String[] args) {
        ReturnDigest[] thread = new ReturnDigest[args.length];

        for (int i=0; i< args.length; i++){
            thread[i] = new ReturnDigest(args[i]);
            thread[i].start();
        }

        for (int i=0; i<args.length; i++){

            while (true){
                byte[] digest = thread[i].getDigest();
                if(digest!= null){
                    StringBuffer result = new StringBuffer(args[i]);
                    result.append(" : ");
                    //
                    break;
                }
            }
        }
    }
}
