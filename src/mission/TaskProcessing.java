package mission;

import java.io.*;
import java.util.*;

public class TaskProcessing {
    private static int[] tag = new int[10];
    private static int createTaskFailCnt = 0;
    private static Map<Integer, Integer> executeTaskFailMap = new HashMap<>(); // (key, value): (태그번호, 실패횟수)
    private static List<Integer> executeTaskFailList;

    public static void main(String[] args) throws IOException {
        commandProcessing();
        printAvailableTagList();
        printCreateTaskFailCnt();
        printExecuteTaskFailTagInfo();
    }

    private static void commandProcessing() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("create")) {
                createTask();
            } else if (input.contains("execute")) {
                executeTask(input);
            }
        }
    }

    // create: task 생성
    private static void createTask() {
        for (int i = 1; i <= 9; i++) {
            if (tag[i] == 1) continue;
            tag[i] = 1; // 태그번호를 등록(1)
            return;
        }
        createTaskFailCnt++;
    }

    // excute [tag]: 특정 태그의 task를 처리
    private static void executeTask(String input) {
        StringTokenizer st = new StringTokenizer(input);
        st.nextToken(); // execute 뒤에 있는 숫자만을 받아야함
        int tagNum = Integer.parseInt(st.nextToken());

        // 입력 태그값의 범위값(1~9)이 아닌 경우 수행 실패 처리
        if (tagNum < 1 || 9 < tagNum) {
            setExecuteTaskFailMap(tagNum);
            return; // 메서드 종료
        }

        // 요청들어온 태그가 미등록(0)인 경우 수행 실패 처리
        if (tag[tagNum] == 0) {
            setExecuteTaskFailMap(tagNum);
        } else {
            // 태스크 수행 성공 -> 태그 번호 미등록(0)으로 업데이트
            tag[tagNum] = 0;
        }
    }

    // 수행 실패한 태그번호를 실패 횟수 카운팅해서 맵에 저장하는 메서드
    private static void setExecuteTaskFailMap(int tagNum) {
        if (executeTaskFailMap.containsKey(tagNum)) {
            executeTaskFailMap.put(tagNum, executeTaskFailMap.get(tagNum) + 1);
        } else {
            executeTaskFailMap.put(tagNum, 1);
        }
    }

    private static void printAvailableTagList() {
        System.out.print("사용가능한 TAG:");
        for (int i = 1; i <= 9; i++) {
            if (tag[i] == 0) {
                System.out.print(" " + i);
            }
        }
    }

    private static void printCreateTaskFailCnt() {
        System.out.println("\nTASK 생성 실패: " + createTaskFailCnt);
    }
    
    private static void printExecuteTaskFailTagInfo() {
        // 정렬을 위해 맵에 있는 키값을 리스트로 변환
        executeTaskFailList = new ArrayList<>(executeTaskFailMap.keySet());
        sortExecuteTaskFailList();

        System.out.print("TASK 수행 실패한 태그:");
        for (Integer failTagNum : executeTaskFailList) {
            System.out.print(" " + failTagNum + "(" + executeTaskFailMap.get(failTagNum) + ")");
        }
    }

    // 밸류(태그 실패 횟수) 내림차순 정렬, 밸류가 동일하다면 키(태그) 오름차순 정렬하는 메서드
    private static void sortExecuteTaskFailList() {
        executeTaskFailList.sort((tagNum1, tagNum2) -> {
            if (Objects.equals(executeTaskFailMap.get(tagNum1), executeTaskFailMap.get(tagNum2))) {
                return tagNum1 - tagNum2;
            } else {
                return executeTaskFailMap.get(tagNum2) - executeTaskFailMap.get(tagNum1);
            }
        });
    }
}