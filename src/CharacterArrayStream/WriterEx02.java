package CharacterArrayStream;

import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriterEx02 {

    public static void main(String[] args) throws Exception {
//        Writer w = new OutputStreamWriter(System.out);
//        char[] nation = {'K', 'O', 'R', 'E', 'A', '한', '국'};
//        for (int i=0; i<nation.length; i++){
//            w.write(nation[i]);
//        }
//        w.write(nation);
//        w.write(nation, 0, nation.length);
//        w.write("KOREA한국");
//        w.write("KOREA한국", 0, 7);
//        w.flush();
        System.out.println(System.getProperty("file.encoding"));

        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        System.out.println(osw.getEncoding());
        osw.flush();
    }

}
