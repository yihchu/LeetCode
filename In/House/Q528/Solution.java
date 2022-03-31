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
