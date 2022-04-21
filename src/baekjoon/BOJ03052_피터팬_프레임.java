package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ03052_피터팬_프레임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] resultLines = new String[5];
        Arrays.fill(resultLines, "");

        for (int i = 0; i < input.length(); i++) {
            char decoration = '#';
            if ((i + 1) % 3 == 0) decoration = '*';
            List<String> lines = new Frame().drawFrame(decoration, input.charAt(i));

            for (int j = 0; j < 5; j++) {
                if (i > 0) {
                    if(resultLines[j].charAt(resultLines[j].length() - 1) == '#') {
                        resultLines[j] = resultLines[j].substring(0, resultLines[j].length() - 1) + decoration;
                    }
                    resultLines[j] += lines.get(j).substring(1);
                } else {
                    resultLines[j] += lines.get(j);
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(resultLines[i]);
        }
    }

    public static class Frame {
        public List<String> drawFrame(char decoration, char word) {
            List<String> lines = new ArrayList<>();
            lines.add(String.format("..%c..", decoration));
            lines.add(String.format(".%c.%c.", decoration, decoration));
            lines.add(String.format("%c.%c.%c", decoration, word, decoration));
            lines.add(String.format(".%c.%c.", decoration, decoration));
            lines.add(String.format("..%c..", decoration));
            return lines;
        }
    }
}
