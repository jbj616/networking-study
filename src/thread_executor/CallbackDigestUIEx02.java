package thread_executor;

public class CallbackDigestUIEx02 {

    private String filename;
    private byte[] digest;

    public CallbackDigestUIEx02(String filename) {
        this.filename = filename;
    }

    public void calculateDigest() {
        CallbackDigestEx02 callbakc = new CallbackDigestEx02(filename, this);
        Thread thread = new Thread(callbakc);
        thread.start();
    }

    void receiveDigest(byte[] digest) {
        this.digest = digest;
        System.out.println(this);
    }

    public String toString() {
        String result = filename + ": ";
        if (digest != null) {
            for (byte dig : digest)
                result += dig;
        } else {
            result += "digest not available";
        }
        return result;

    }

    public static void main(String[] args) {
        for (String filename : args) {
            // Calculate the digest
            CallbackDigestUIEx02 d
                    = new CallbackDigestUIEx02(filename);
            d.calculateDigest();
        }

    }
}
