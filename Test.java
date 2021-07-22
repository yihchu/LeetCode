import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(-3);
        queue.add(-5);
        queue.add(-1);
        queue.add(-9);
        queue.add(-4);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}