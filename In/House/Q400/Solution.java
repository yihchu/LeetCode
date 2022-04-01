package In.House.Q400;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    // 超出内存限制
//    public int findNthDigit1(int n) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 1; i < Integer.MAX_VALUE; ++i) {
//            builder.append(i);
//            if (builder.length() > n) {
//                break;
//            }
//        }
//        return builder.charAt(n - 1) - '0';
//    }

    public int findNthDigit(int n) {
        int thres = 9, times = 1;
        if (n <= thres) {
            return n;
        }
        n -= thres;
        while (true) {
            thres *= 10;
            int num = 9 * (times + 1) * (int)Math.pow(10, times);
            if (thres >= 900000000 || n <= num) {
                break;
            }
            n -= num;
            ++ times;
        }
        int start = (int) Math.pow(10, times);
        int count = n / (times + 1);
        int idx = n % (times + 1);
        return (idx == 0 ? ("" + (start + count - 1)).charAt(times) : ("" + (start + count)).charAt(idx - 1)) - '0';
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findNthDigit(3)); // 3
        System.out.println(slt.findNthDigit(11)); // 0
        System.out.println(slt.findNthDigit(12)); // 1
        System.out.println(slt.findNthDigit(15)); // 2
        System.out.println(slt.findNthDigit(97)); // 3
        System.out.println(slt.findNthDigit(6874)); // 1
        System.out.println(slt.findNthDigit(82745)); // 1
        System.out.println(slt.findNthDigit(1000000000)); // 1
    }

}


