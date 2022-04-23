package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] word = new char[20][20];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                word[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < 5; j++) {
                if(word[j][i] == '\0') continue;
                System.out.print(word[j][i]);
            }
        }
    }
}
