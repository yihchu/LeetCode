package In.House.Q732;

import java.util.HashMap;
import java.util.Map;

// CV大法，线段树
public class MyCalendarThree {

    private Map<Integer, Integer> tree;
    private Map<Integer, Integer> lazy;

    public MyCalendarThree() {
        this.tree = new HashMap<>();
        this.lazy = new HashMap<>();
    }

    public int book(int start, int end) {
        update(start, end - 1, 0 ,1000000000, 1);
        return tree.getOrDefault(1, 0);
    }

    public void update(int start, int end, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        if (start <= l && r <= end) {
            this.tree.put(idx, this.tree.getOrDefault(idx, 0) + 1);
            this.lazy.put(idx, this.lazy.getOrDefault(idx, 0) + 1);
        } else {
            int mid = (l + r) / 2;
            update(start, end, l, mid, 2 * idx);
            update(start, end, mid + 1, r, 2 * idx + 1);
            tree.put(idx, lazy.getOrDefault(idx, 0) + Math.max(tree.getOrDefault(2 * idx, 0), tree.getOrDefault(2 * idx + 1, 0)));
        }
    }

    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(50, 60));
        System.out.println(calendar.book(10, 40));
        System.out.println(calendar.book(5, 15));
        System.out.println(calendar.book(5, 10));
        System.out.println(calendar.book(25, 55));
    }

}
