package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ07567_그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bowl = br.readLine();
        int bowlHeight = 10;

        for (int i = 1; i < bowl.length(); i++) {
            if (bowl.charAt(i - 1) != bowl.charAt(i)) {
                bowlHeight += 10;
            } else {
                bowlHeight += 5;
            }
        }
        System.out.println(bowlHeight);
    }
}
