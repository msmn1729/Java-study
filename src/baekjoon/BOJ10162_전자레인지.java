package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162_전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        int aCount, bCount, cCount;

        aCount = time / 300;
        time %= 300;
        bCount = time / 60;
        time %= 60;
        cCount = time / 10;
        time %= 10;

        if (time > 0) {
            System.out.println(-1);
        } else {
            System.out.println(aCount + " " + bCount + " " + cCount);
        }
    }
}
