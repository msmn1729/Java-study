package baekjoon;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class BOJ10703_유성 {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // board 입력
        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 유성이 낙하할 거리 계산 -> X와 #의 거리 중 최솟값-1
        int fallingDist = r;
        for (int j = 0; j < c; j++) {
            int startRow = -1, endRow = r;
            // 해당 열의 위부터 가장 아래 X의 행을 찾음
            for (int i = 0; i < r; i++) {
                if (board[i][j] == 'X') {
                    startRow = i;
                }
            }
            // 해당 열에 유성이 없는 경우 패스
            if (startRow == -1) {
                continue;
            }

            // 해당 열의 아래부터 가장 위 #의 행을 찾음
            for (int i = r - 1; i >= 0; i--) {
                if (board[i][j] == '#') {
                    endRow = i;
                }
            }
            int dist = endRow - startRow - 1;
            fallingDist = Math.min(fallingDist, dist);
        }

        // 낙하할 거리만큼 유성을 아래로 이동
        for (int j = 0; j < c; j++) {
            for (int i = r - 1; i >= 0; i--) {
                // 낙하하는 좌표로 이동
                if (board[i][j] == 'X' && board[i + fallingDist][j] == '.') {
                    board[i][j] = '.';
                    board[i + fallingDist][j] = 'X';
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}