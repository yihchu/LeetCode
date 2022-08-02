package In.House.Q622;

public class MyCircularQueue {

    private int capacity;
    private int size;
    private int head, tail;
    private int[] array;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.array = new int[this.capacity];
        this.head = this.tail = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (this.size == this.capacity) {
            return false;
        }
        ++ this.size;
        this.array[this.tail] = value;
        this.tail = (this.tail + 1) % this.capacity;
        return true;
    }

    public boolean deQueue() {
        if (this.size == 0) {
            return false;
        }
        -- this.size;
        this.head = (this.head + 1) % this.capacity;
        return true;
    }

    public int Front() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[this.head];
    }

    public int Rear() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[(this.tail + this.capacity - 1) % this.capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为3
        System.out.println(circularQueue.enQueue(1));  // 返回true
        System.out.println(circularQueue.enQueue(2));  // 返回true
        System.out.println(circularQueue.enQueue(3));  // 返回true
        System.out.println(circularQueue.enQueue(4));  // 返回false，队列已满
        System.out.println(circularQueue.Rear());  // 返回3
        System.out.println(circularQueue.isFull());  // 返回true
        System.out.println(circularQueue.deQueue());  // 返回true
        System.out.println(circularQueue.enQueue(4));  // 返回true
        System.out.println(circularQueue.Rear());  // 返回4
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */