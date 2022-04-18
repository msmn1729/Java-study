package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ03052_피터팬_프레임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        char[][] result = new char[5][5 + 4 * word.length()];
        char[][] frame = {"..#..".toCharArray(),
                          ".#.#.".toCharArray(),
                          "#...#".toCharArray(),
                          ".#.#.".toCharArray(),
                          "..#..".toCharArray()};

        if (word.length() == 0) {
            for (int i = 0; i < 5; i++) {
                System.out.println(frame[i]);
            }
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            frame[2][2] = word.charAt(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(result[j][k + (4 * i)] == '*') {
                        continue; // 이미 *인 경우 패스
                    }
                    if((i + 1) % 3 == 0 && (frame[j][k] == '#')) result[j][k + (4 * i)] = '*';
                    else result[j][k + (4 * i)] = frame[j][k];
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(result[i]);
            if(i < 4) System.out.println();
        }
    }
}
