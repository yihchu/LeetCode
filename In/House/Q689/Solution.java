package In.House.Q689;


public class Solution {

//    // 考虑的不对，带重叠了
//    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        int len = nums.length;
//        int[] sums = new int[len - k + 1];
//        int[] tres = new int[3];
//        for (int i = 0; i < sums.length; ++i) {
//            int sum = 0;
//            for (int j = i; j < i + k; ++j) {
//                sum += nums[j];
//            }
//            sums[i] = sum;
//            int curIdx = i;
//            for (int j = 0; j < 3; ++j) {
//                if (sum > sums[tres[j]]) {
//                    int tmp = tres[j];
//                    sum = sums[tmp];
//                    tres[j] = curIdx;
//                    curIdx = tmp;
//                }
//            }
//        }
//        Arrays.sort(tres);
//        return tres;
//    }

    // 官方答案，滑动窗口，照抄
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        int len = nums.length;
        for (int i = k * 2; i < len; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i < k * 3 - 1) {
                continue;
            }
            if (sum1 > maxSum1) {
                maxSum1 = sum1;
                maxSum1Idx = i - k * 3 + 1;
            }
            if (maxSum1 + sum2 > maxSum12) {
                maxSum12 = maxSum1 + sum2;
                maxSum12Idx1 = maxSum1Idx;
                maxSum12Idx2 = i - k * 2 + 1;
            }
            if (maxSum12 + sum3 > maxTotal) {
                maxTotal = maxSum12 + sum3;
                result[0] = maxSum12Idx1;
                result[1] = maxSum12Idx2;
                result[2] = i - k + 1;
            }
            sum1 -= nums[i - k * 3 + 1];
            sum2 -= nums[i - k * 2 + 1];
            sum3 -= nums[i - k + 1];
        }
        return result;
    }

    private static void test(int[] array, int k) {
        Solution slt = new Solution();
        int[] result = slt.maxSumOfThreeSubarrays(array, k);
        for (int r: result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 1, 2, 6, 7, 5, 1}, 2); // [0, 3, 5]
        test(new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1}, 2); // [0, 2, 4]
    }

}

