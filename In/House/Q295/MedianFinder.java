package In.House.Q295;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> p;
    private Queue<Integer> q;
    private double mid;

    /** initialize your data structure here. */
////    public MedianFinder() {
    public MedianFinder() {
        p = new PriorityQueue<>((a, b) ->  b - a);
        q = new PriorityQueue<>();
        mid = 0;
    }

    public void addNum(int num) {
        if (p.isEmpty()) {
            p.add(num);
            mid = num;
            return;
        } else if (q.isEmpty()) {
            if (num >= p.peek()) {
                q.add(num);
            } else {
                q.add(p.poll());
                p.add(num);
            }
            mid = ((double) p.peek() + q.peek()) / 2.0;
            return ;
        }
        if (num < p.peek()) {
            p.add(num);
            if (p.size() > q.size() + 1) {
                q.add(p.poll());
            }
        } else if (num > q.peek()) {
            q.add(num);
            if (p.size() < q.size()) {
                p.add(q.poll());
            }
        } else if (p.size() > q.size()) {
            q.add(num);
        } else {
            p.add(num);
        }
        mid = p.size() == q.size() ? ((double) p.peek() + q.peek()) / 2.0 : p.peek();
    }

    public double findMedian() {
        return mid;
    }

    public static void main(String[] args) {
        MedianFinder obj;
//        // test1
//        obj = new MedianFinder();
//        obj.addNum(1);
//        obj.addNum(2);
//        System.out.println(obj.findMedian()); // 1.5
//        obj.addNum(3);
//        System.out.println(obj.findMedian()); // 2
//        obj.addNum(4);
//        System.out.println(obj.findMedian()); // 2.5
        // test2
        obj = new MedianFinder();
        obj.addNum(40);
        obj.addNum(12);
        obj.addNum(16);
        obj.addNum(14);
        obj.addNum(35);
        obj.addNum(19);
        System.out.println(obj.findMedian());
    }

}
/*
Your MedianFinder object will be instantiated and called as such:
MedianFinder obj = new MedianFinder();
obj.addNum(num);
double param_2 = obj.findMedian();
*/



