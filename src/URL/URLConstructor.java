package URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLConstructor {

    public static void main(String[] args) {

        try{
            URL u = new URL("http", "www.eff.org", "/blueribbon.html#intro");

            System.out.println(u.toString());

            URL u1 = new URL("https://metalab.unc.edu/javafag/index.html");
            URL u2 = new URL(u1, "mailinglist.html");
            System.out.println(u2);

            URL u3 = new URL("https://A/B/C/index.html");
            URL u4 = new URL(u3, "/mailinglist.html");
            System.out.println(u4);

            URL u5 = new URL("https://A/B/index.html");
            URL u6 = new URL(u5, "A/B/mailinglist.html");
            System.out.println(u6);


        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
