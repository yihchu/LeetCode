import java.util.PriorityQueue;
import java.util.Queue;

public class LT295 {

    private Queue<Integer> p;
    private Queue<Integer> q;
    private double mid;

    /** initialize your data structure here. */
////    public MedianFinder() {
    public LT295() {
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
        LT295 lt295;
//        // test1
//        lt295 = new LT295();
//        lt295.addNum(1);
//        lt295.addNum(2);
//        System.out.println(lt295.findMedian()); // 1.5
//        lt295.addNum(3);
//        System.out.println(lt295.findMedian()); // 2
//        lt295.addNum(4);
//        System.out.println(lt295.findMedian()); // 2.5
        // test2
        lt295 = new LT295();
        lt295.addNum(40);
        lt295.addNum(12);
        lt295.addNum(16);
        lt295.addNum(14);
        lt295.addNum(35);
        lt295.addNum(19);
        System.out.println(lt295.findMedian());
    }

}
/*
Your MedianFinder object will be instantiated and called as such:
MedianFinder obj = new MedianFinder();
obj.addNum(num);
double param_2 = obj.findMedian();
*/

/**
Link: https://leetcode-cn.com/problems/find-median-from-data-stream/

中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2, 3, 4]的中位数是3
[2, 3]的中位数是(2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

进阶:
如果数据流中所有整数都在0到100范围内，你将如何优化你的算法？
如果数据流中99%的整数都在0到100范围内，你将如何优化你的算法？

*/

