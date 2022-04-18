package mission.taskProcessing_OOP;

import java.util.PriorityQueue;

public class Tag {
    // OOP 개념: 사용자의 입력이 바뀌어서 태그의 자료형이 변해도 Tag 클래스만 수정하면 되도록 구현해야함
    PriorityQueue<Integer> tagQueue = new PriorityQueue<>();

    public Tag() {
        for (int i = 1; i <= 9; i++) {
            tagQueue.add(i);
        }
    }

    public int getTag() {
        return tagQueue.poll();
    }

    public boolean existTag() {
        return !tagQueue.isEmpty();
    }
}
