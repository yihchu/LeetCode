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


/**
Ques: 最后一块石头的重量
Link: https://leetcode-cn.com/problems/last-stone-weight/

有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为x和y，且x <= y。那么粉碎的可能结果如下：
如果x == y，那么两块石头都会被完全粉碎；
如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y - x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回0。

示例：
输入：[2, 7, 4, 1, 8, 1]
输出：1
解释：
先选出7和8，得到1，所以数组转换为[2, 4, 1, 1, 1]，
再选出2和4，得到2，所以数组转换为[2, 1, 1, 1]，
接着是2和1，得到1，所以数组转换为[1, 1, 1]，
最后选出1和1，得到0，最终数组转换为[1]，这就是最后剩下那块石头的重量。

提示：
1 <= stones.length <= 30
1 <= stones[i] <= 1000

*/

//           0
//     1           2
//   3    4      5     6
//7    8 9  10 11 12 13  14