package Chaper02_Stream;

import java.io.IOException;
import java.io.OutputStream;

public class GenerateChar {
    public static void main(String[] args) throws Exception {
        generateCharacters(System.out);
    }

    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPC = 33;
        int numberPC = 94;
        int nPerLine = 72;
        int start = firstPC;
        int time = 0;
        while (time < 10) {
            for (int i = start; i < start + nPerLine; i++) {
                out.write(((i - firstPC) % numberPC) + firstPC);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPC) % numberPC + firstPC;
            time++;
        }
    }
}
