package In.House.Q396;

import java.util.Arrays;

public class Solution {

//    // 超时
//    public int maxRotateFunction(int[] nums) {
//        int len = nums.length, max = Integer.MIN_VALUE;
//        for (int turn = 0; turn < len; ++turn) {
//            int sum = 0;
//            for (int i = len - 1; i > 0; --i) {
//                sum += i * nums[(i + turn) % len];
//            }
//            max = Math.max(max, sum);
//        }
//        return max;
//    }


    // CV大法
    // 成天写代码，把数学这么好用的工具都给忘了
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxRotateFunction(new int[] {4, 3, 2, 6})); // 26
        System.out.println(slt.maxRotateFunction(new int[] {100})); // 0
    }

}
