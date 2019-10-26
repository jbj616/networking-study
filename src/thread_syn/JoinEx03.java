package thread_syn;

import thread_executor.ReturnDigest;

public class JoinEx03 {

    public static void main(String[] args) {

        String[] tmpArgs = {"file/file02.dat", "file/file03.dat", "file/outputfile"};

        ReturnDigest[] digests = new ReturnDigest[tmpArgs.length];

        for (int i=0; i<tmpArgs.length; i++){
            digests[i] = new ReturnDigest(tmpArgs[i]);
            digests[i].start();
        }

        for (int i=0; i<tmpArgs.length; i++){
            try{
                digests[i].join();

                StringBuffer result = new StringBuffer(tmpArgs[i]);
                result.append(" : ");
                byte[] digest = digests[i].getDigest();
                result.append(digests.toString());
                System.out.println(result);
            }catch (InterruptedException ex){
                ex.printStackTrace();
                System.err.println("Thread Interrupted before completion");
            }
        }
    }

}
