package mission.taskProcessing_OOP;

import java.util.PriorityQueue;

public class Tag {
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
