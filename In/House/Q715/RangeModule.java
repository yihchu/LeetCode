package In.House.Q715;

import java.util.*;

class RangeModule {

    private List<int[]> list;

    public RangeModule() {
        this.list = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        int len = this.list.size(), idx = -1;
        if (len == 0) {
            this.list.add(new int[] {left, right});
            return;
        }
        for (int i = 0; i < len; ++i) {
            int[] cur = this.list.get(i);
            if (cur[1] < left) {
                continue;
            } else if (cur[0] <= left && cur[1] >= right) {
                break;
            } else if (cur[0] <= left && cur[1] < right) {
                cur[1] = right;
                idx = i;
                break;
            } else if (cur[0] <= right) {
                cur[0] = left;
                cur[1] = Math.max(cur[1], right);
                idx = i;
                break;
            } else if (cur[0] > right) {
                this.list.add(i, new int[] {left, right});
                break;
            }
        }
        if (left > this.list.get(len - 1) [1]) {
            this.list.add(new int[] {left, right});
        }
        if (idx < 0) {
            return;
        }
        while (this.list.size() > idx + 1) {
            int[] cur = this.list.get(idx), nxt = this.list.get(idx + 1);
            if (cur[1] < nxt[0]) {
                break;
            } else {
                cur[1] = Math.max(cur[1], nxt[1]);
                this.list.remove(idx + 1);
            }
        }
    }

    public boolean queryRange(int left, int right) {
        for (int[] arr: this.list) {
            if (arr[0] <= left && right <= arr[1]) {
                return true;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        if (this.list.isEmpty()) {
            return;
        }
        if (left >= this.list.get(this.list.size() - 1)[1]) {
             return;
        }
        int idx = 0;
        while (idx < this.list.size()) {
            int[] first = this.list.get(idx);
            if (left >= first[0]) {
                break;
            } else if (right >= first[1]) {
                this.list.remove(idx);
            } else if (first[0] < right) {
                first[0] = right;
                return;
            } else {
                return;
            }
        }
        int len = this.list.size();
        while (idx < len && this.list.get(idx)[1] < left) {
            ++idx;
        }
        if (idx >= len) {
            return;
        }
        int[] t1 = this.list.get(idx);
        if (t1[0] < left) {
            this.list.add(++ idx, new int[] {left, t1[1]});
            t1[1] = left;
        }
        while (idx < this.list.size()) {
            int[] t2 = this.list.get(idx);
            if (t2[1] < right) {
                this.list.remove(idx);
            } else if (t2[1] == right) {
                this.list.remove(idx);
                return;
            } else if (t2[0] <= right) {
                t2[0] = right;
                return;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
//        RangeModule obj = new RangeModule();
//        obj.addRange(15, 20);
//        obj.addRange(100, 101);
//        obj.addRange(10, 30);
//        obj.addRange(40, 50);
//        obj.addRange(8, 12);
//        obj.addRange(55, 80);
//        obj.addRange(28, 70);
//        obj.addRange(80, 82);
//
//        obj.removeRange(80, 82);
//        obj.removeRange(28, 70);
//        obj.removeRange(55, 80);
//        obj.removeRange(8, 12);
//        obj.removeRange(40, 50);
//        obj.removeRange(10, 30);
//        obj.removeRange(100, 101);
//        obj.removeRange(15, 20);
//        System.out.println();

        RangeModule range = new RangeModule();
        System.out.println(range.queryRange(1, 4));
        System.out.println(range.queryRange(6, 10));
        range.addRange(2, 6);
        range.addRange(2, 8);
        range.addRange(4, 7);
        System.out.println(range.queryRange(2, 5));
        range.removeRange(1, 10);
        range.removeRange(3, 5);
        range.removeRange(1, 2);

    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();t2[1]
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */