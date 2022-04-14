package programmers;

import java.util.ArrayList;

public class 다트_게임 {
    public static void main(String[] args) {
        System.out.println(new 다트_게임().solution("1S2D*3T"));
        System.out.println(new 다트_게임().solution("1D2S#10S"));
        System.out.println(new 다트_게임().solution("1D2S0T"));
        System.out.println(new 다트_게임().solution("1S*2T*3S"));
        System.out.println(new 다트_게임().solution("1D#2S*3S"));
    }

    public int solution(String dartResult) {
        int answer = 0;
        int num = 0;
        ArrayList<Integer> expressions = new ArrayList<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            // 두자리 정수도 연산 가능해야함 -> 여기선 10이 들어올 수 있음
            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
                continue; // 숫자일 경우 아래 연산은 불필요하므로 패스
            }
            if (c == 'S') {
                expressions.add(num);
            } else if (c == 'D') {
                expressions.add(num * num);
            } else if (c == 'T') {
                expressions.add(num * num * num);
            } else if (c == '*') {
                // 리스트의 마지막 값을 한번 더 더해줌
                expressions.set(expressions.size() - 1, expressions.get(expressions.size() - 1) * 2);
                if (expressions.size() >= 2) {
                    // 리스트 사이즈가 2이상인 경우 마지막 이전의 값도 추가로 더해줌
                    expressions.set(expressions.size() - 2, expressions.get(expressions.size() - 2) * 2);
                }
            } else if (c == '#') {
                expressions.set(expressions.size() - 1, expressions.get(expressions.size() - 1) * -1);
            }
            num = 0;
        }

        for (Integer expression : expressions) {
            answer += expression;
        }

        return answer;
    }
}
