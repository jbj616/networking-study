package URL;

import java.net.URL;

public class URLEquality {

    public static void main(String[] args) throws Exception{

        URL www = new URL("http://www.ibiblio.org/");
        URL ibiblio = new URL("http://ibiblio.org/");

        if(ibiblio.equals(www)){
            System.out.println("isSame");
        }else{
            System.out.println("isNotSame");
        }
    }

}
