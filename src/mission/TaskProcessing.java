package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskProcessing {
    private static int[] tag = new int[10];
    private static int createTaskFailCnt = 0;

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("create")) {
                createTask();
            } else if (input.equals("execute")) {
                excuteTask();
            }
        }
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
    private static void excuteTask() {

    }
}
