package programmers;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 중복 제거
        HashSet<String> reportSet = new HashSet<>();
        for (String rep : report) {
            reportSet.add(rep);
        }

        // 2. notifyListHash 만들기
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for (String rep : reportSet) {
            int blankIdx = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIdx);
            String reportee = rep.substring(blankIdx + 1);

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, new ArrayList<>());
            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }

        // 3. notifyListHash 를 기반으로 reporterHash 만들기
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHash.values()) {
            if (notifyList.size() >= k) {
                for (String reporter : notifyList) {
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        // 4. reporterHash 를 기반으로 answer 배열을 채운다
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
//        solution.solution(new String[]{}, new String[]{"aa", "aa"}, 2);
    }
}