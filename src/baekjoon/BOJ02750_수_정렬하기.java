package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ02750_수_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arrayList.add(num);
        }
        Collections.sort(arrayList);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }
}
