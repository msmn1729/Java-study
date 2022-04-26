package baekjoon;

import java.io.*;

public class BOJ10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        myDeque myDeque = new myDeque();
        StringBuilder sb = new StringBuilder();
        int value;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String command = s[0];

            switch (command) {
                case "push_front":
                    value = Integer.parseInt(s[1]);
                    myDeque.pushFront(value);
                    break;

                case "push_back":
                    value = Integer.parseInt(s[1]);
                    myDeque.pushBack(value);
                    break;

                case "pop_front":
                    sb.append(myDeque.popFront()).append("\n");
                    break;

                case "pop_back":
                    sb.append(myDeque.popBack()).append("\n");
                    break;

                case "size":
                    sb.append(myDeque.size()).append("\n");
                    break;

                case "empty":
                    sb.append(myDeque.empty()).append("\n");
                    break;

                case "front":
                    sb.append(myDeque.front()).append("\n");
                    break;

                case "back":
                    sb.append(myDeque.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static class myDeque {
        private Node front;
        private Node rear;
        private int size = 0;

        public int size() {
            return size;
        }

        public int empty() {
            if (front == null) {
                return 1;
            }
            return 0;
        }

        public int front() {
            if (front == null) {
                return -1;
            }
            return front.value;
        }

        public int back() {
            if (rear == null) {
                return -1;
            }
            return rear.value;
        }

        public void pushFront(int value) {
            Node node = new Node(value);
            // 덱이 비어있는 경우
            if (front == null) {
                front = rear = node;
                front.setNextNode(rear);
                rear.setPrevNode(front);
            } else {
                front.setPrevNode(node); // front의 prev가 새로 만든 노드를 가리키게함
                node.setNextNode(front);
                front = node; // 이제 front는 새로만든 노드가 됨
            }
            size++;
        }

        public void pushBack(int value) {
            Node node = new Node(value);
            // 덱이 비어있는 경우
            if (rear == null) {
                front = rear = node;
                front.setNextNode(rear);
                rear.setPrevNode(front);
            } else {
                rear.setNextNode(node); // rear의 next가 새로 만든 노드를 가리키게함
                node.setPrevNode(rear);
                rear = node; // 이제 rear는 새로만든 노드가 됨
            }
            size++;
        }

        public int popFront() {
            if (front == null) {
                return -1;
            }

            size--;
            Node removeNode = front;
            front = removeNode.nextNode;
            if (front != null) {
                front.setPrevNode(null);
            }

            // 큐가 비었을 때 초기화를 해줘야함
            if (size == 0) {
                front = rear = null;
            }

            return removeNode.value;
        }

        public int popBack() {
            if (rear == null) {
                return -1;
            }

            size--;
            Node removeNode = rear;
            rear = removeNode.prevNode;
            if (rear != null) {
                rear.setNextNode(null);
            }

            // 큐가 비었을 때 초기화를 해줘야함
            if (size == 0) {
                front = rear = null;
            }

            return removeNode.value;
        }
    }

    private static class Node {
        private final int value;
        private Node prevNode;
        private Node nextNode;

        public Node(int value) {
            this.value = value;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
