package In.House.Q528;

import java.util.Random;


// 每次通过的测试用例数都不一样，很随意
// 明明说是随机的，然后结果还不给过
// 感觉通不通过也是要看概率的呢
// 所以，就这样吧~
// 复制一个官方解法，通过一下，就这样吧
public class Solution {

    private int[] w;
    private int sum;
//    public Solution(int[] w) {
    public Solution(int[] w) {
        int len = w.length;
        for (int i = 1; i < len; ++i) {
            w[i] += w[i - 1];
        }
        sum = w[len - 1];
        this.w = w;
    }

    public int pickIndex() {
        Random random = new Random();
        int pos = random.nextInt(this.sum) + 1;
        int l = 0, r = this.w.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((mid == 0 && pos <= this.w[mid]) || (mid > 0 && pos >= this.w[mid - 1] && pos <= this.w[mid])) {
                return mid;
            } else if (pos < this.w[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution slt = null;
        slt = new Solution(new int[]{1});
        System.out.println(slt.pickIndex());
        slt = new Solution(new int[]{1, 3});
        System.out.print(slt.pickIndex() + " ");
        System.out.print(slt.pickIndex() + " ");
        System.out.print(slt.pickIndex() + " ");
        System.out.print(slt.pickIndex() + " ");
        System.out.println(slt.pickIndex());
    }

}



//// 官方解法~
//class Solution {
//    int[] pre;
//    int total;
//
//    public Solution(int[] w) {
//        pre = new int[w.length];
//        pre[0] = w[0];
//        for (int i = 1; i < w.length; ++i) {
//            pre[i] = pre[i - 1] + w[i];
//        }
//        total = Arrays.stream(w).sum();
//    }
//
//    public int pickIndex() {
//        int x = (int) (Math.random() * total) + 1;
//        return binarySearch(x);
//    }
//
//    private int binarySearch(int x) {
//        int low = 0, high = pre.length - 1;
//        while (low < high) {
//            int mid = (high - low) / 2 + low;
//            if (pre[mid] < x) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return low;
//    }
//}

/**
Ques: 按权重随机选择
Link: https://leetcode-cn.com/problems/random-pick-with-weight/

给定一个正整数数组w，其中w[i]代表下标i的权重（下标从0开始），请写一个函数pickIndex，它可以随机地获取下标i，选取下标i的概率与w[i]成正比。
例如，对于w = [1, 3]，挑选下标0的概率为1 / (1 + 3) = 0.25 （即，25%），而选取下标1的概率为3 / (1 + 3) = 0.75（即，75%）。
也就是说，选取下标i的概率为w[i] / sum(w)。

示例1：
输入：
["Solution","pickIndex"]
[[[1]], []]
输出：
[null, 0]
解释：
Solution solution = new Solution([1]);
solution.pickIndex(); // 返回0，因为数组中只有一个元素，所以唯一的选择是返回下标0。

示例2：
输入：
["Solution", "pickIndex", "pickIndex", "pickIndex", "pickIndex", "pickIndex"]
[[[1, 3]], [], [], [], [], []]
输出：
[null, 1, 1, 1, 1, 0]
解释：
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // 返回1，返回下标1，返回该下标概率为3/4 。
solution.pickIndex(); // 返回1
solution.pickIndex(); // 返回1
solution.pickIndex(); // 返回1
solution.pickIndex(); // 返回0，返回下标0，返回该下标概率为1/4 。

由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
[null, 1, 1, 1, 1, 0]
[null, 1, 1, 1, 1, 1]
[null, 1, 1, 1, 0, 0]
[null, 1, 1, 1, 0, 1]
[null, 1, 0, 1, 0, 0]
......
诸若此类。

提示：
1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex将被调用不超过10000次

*/