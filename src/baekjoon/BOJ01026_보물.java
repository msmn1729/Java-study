package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ01026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar1 = new int[n];
        int[] ar2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar1[i] * ar2[n - i - 1];
        }
        System.out.println(sum);
    }
}
