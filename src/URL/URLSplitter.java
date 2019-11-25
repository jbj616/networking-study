package URL;

import java.net.URL;

public class URLSplitter {

    public static void main(String[] args) throws Exception{
        URL u = new URL("https://www.google.com/search?q=apple&rlz=1C5CHFA_enKR834KR834&oq=apple&aqs=chrome..69i57j35i39j0j69i60l2j69i61.796j0j9&sourceid=chrome&ie=UTF-8");
        System.out.println("this URL is "+u);
        System.out.println("The scheme is "+u.getProtocol());
        System.out.println("The user info is "+u.getUserInfo());

        String host = u.getHost();
        if(host!=null){
            int atSign = host.indexOf('@');
            if(atSign!=-1){
                host = host.substring(atSign+1);
                System.out.println("The host is "+host);
            }
        }else{
            System.out.println("The host is null");
        }

        System.out.println("The port is "+u.getPort());
        System.out.println("The path is "+u.getPath());
        System.out.println("The ref is "+u.getRef());
        System.out.println("The query string is "+u.getQuery());
    }

}
