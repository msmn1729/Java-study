package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ01453_피시방_알바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seat = new int[101];
        int ans = 0;
        String[] ar = br.readLine().split(" ");

        for (int i = 0; i < ar.length; i++) {
            int num = Integer.parseInt(ar[i]);
            if (seat[num] == 1) {
                ans++;
                continue;
            }
            seat[num] = 1;
        }
        System.out.println(ans);
    }
}
