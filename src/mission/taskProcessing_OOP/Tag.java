package mission.taskProcessing_OOP;

import java.util.PriorityQueue;

public class Tag {
    // OOP 개념: 사용자의 입력이 바뀌어서 태그의 자료형이 변해도 Tag 클래스만 수정하면 되도록 구현해야함
    PriorityQueue<Integer> tagQueue = new PriorityQueue<>();

    public Tag() {
        for (int i = 1; i <= 9; i++) {
            setTag(i);
        }
    }

    public int getTag() {
        if(tagQueue.isEmpty()) return -1;
        return tagQueue.poll();
    }

    public void setTag(int tag) {
        tagQueue.add(tag);
    }

    public boolean isEmpty() {
        return tagQueue.isEmpty();
    }

    public boolean isAvailableTag(int tag) {
        return !tagQueue.contains(tag);
    }
}
