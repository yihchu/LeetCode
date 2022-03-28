package In.House.Q1046;

public class Solution {

    public static class MaxHeap {
        private int len;
        private int[] data;

        public MaxHeap(int[] arr) {
            this.data = new int[arr.length];
            for (int a: arr) {
                add(a);
            }
        }

        public void add(int n) {
            if (n == 0){
                return;
            }
            data[this.len++] = n;
            int idx = this.len - 1;
            int p = (idx - 1) / 2;
            while (this.data[p] < this.data[idx]) {
                int tmp = this.data[p];
                this.data[p] = this.data[idx];
                this.data[idx] = tmp;
                idx = p;
                p = (idx - 1) / 2;
            }
        }

        public int peek() {
            int p = this.data[0];
            this.data[0] = this.data[--this.len];
            int idx = 0;
            int l, r;
            while (true) {
                int c = idx;
                l = c * 2 + 1;
                r = l + 1;
                c = l < this.len && this.data[c] < this.data[l] ? l : c;
                c = r < this.len && this.data[c] < this.data[r] ? r : c;
                if (c == idx) {
                    break;
                }
                int t = (c == l ? l : r);
                int tmp = this.data[t];
                this.data[t] = this.data[idx];
                this.data[idx] = tmp;
                idx = c;
            }
            return p;
        }

        public int size() {
            return len;
        }
    }

    public int lastStoneWeight(int[] stones) {
        MaxHeap mh = new MaxHeap(stones);
        while (mh.size() > 1) {
            mh.add(mh.peek() - mh.peek());
        }
        return mh.size() > 0 ? mh.peek() : 0;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(slt.lastStoneWeight(new int[]{2, 2})); // 0
        System.out.println(slt.lastStoneWeight(new int[]{9, 10, 1, 7, 3})); // 2
        System.out.println(slt.lastStoneWeight(new int[]{2, 6, 3, 9, 9, 3, 8})); //0
        System.out.println(slt.lastStoneWeight(new int[]{4, 3, 4, 3, 2})); // 2
    }

}


