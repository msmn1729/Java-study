package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskProcessing {
    private static int[] tag = new int[10];
    private static int createTaskFailCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("create")) {
                createTask();
            } else if (input.contains("execute")) {
                StringTokenizer st = new StringTokenizer(input);
                st.nextToken(); // execute 뒤에 있는 숫자만을 받아야함
                int tagNum = Integer.parseInt(st.nextToken());
                System.out.println(tagNum);
                excuteTask(tagNum);
            }
        }

        System.out.print("사용가능한 TAG: ");
        for (int i = 1; i <= 9; i++) {
            if (tag[i] == 0) {
                System.out.print(" " + i);
            }
        }
        System.out.println("\nTASK 생성 실패: " + createTaskFailCnt);
        System.out.println("TASK 수행 실패한 태그: ");
    }

    // create: task 생성
    private static void createTask() {
        for (int i = 1; i <= 9; i++) {
            if (tag[i] == 0) {
                tag[i] = 1;
                return;
            }
        }
        createTaskFailCnt++;
    }

    // excute [tag]: 특정 태그의 task를 처리
    private static void excuteTask(int tagNum) {
        tag[tagNum] = 0;
    }
}
