import java.util.Arrays;

public class LT1838 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 1, len = nums.length, diff = 0, max = 1;
        if (len == 1) {
            return max;
        }
        while (r < len) {
            diff += (nums[r] - nums[r - 1]) * (r - l);
            while (diff > k) {
                diff -= (nums[r] - nums[l ++]);
            }
            int tmp = r - l + 1;
            max = max < tmp ? tmp : max;
            ++r;
        }
        return max;
    }

    public static void main(String[] args) {
        LT1838 lt1838 = new LT1838();
        System.out.println(lt1838.maxFrequency(new int[]{1, 2, 4}, 5)); // 3
        System.out.println(lt1838.maxFrequency(new int[]{1, 4, 8, 13}, 5)); // 2
        System.out.println(lt1838.maxFrequency(new int[]{3, 9, 6}, 2)); // 1
        System.out.println(lt1838.maxFrequency(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982
                , 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935
                , 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924
                , 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985
                , 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975
                , 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056)); // 73


//        int[] arr = new int[]{9902,
//                9903,
//                9904,
//                9907,
//                9910,
//                9911,
//                9911,
//                9911,
//                9913,
//                9914,
//                9916,
//                9916,
//                9916,
//                9917,
//                9920,
//                9922,
//                9923,
//                9923,
//                9923,
//                9924,
//                9925,
//                9925,
//                9925,
//                9926,
//                9927,
//                9927,
//                9928,
//                9928,
//                9930,
//                9930,
//                9930,
//                9930,
//                9932,
//                9932,
//                9933,
//                9934,
//                9935,
//                9935,
//                9936,
//                9937,
//                9938,
//                9938,
//                9943,
//                9945,
//                9945,
//                9946,
//                9947,
//                9952,
//                9952,
//                9954,
//                9954,
//                9957,
//                9959,
//                9963,
//                9964,
//                9964,
//                9966,
//                9970,
//                9972,
//                9972,
//                9973,
//                9973,
//                9974,
//                9975,
//                9975,
//                9975,
//                9977,
//                9977,
//                9981,
//                9982,
//                9983,
//                9983,
//                9985,
//                9985,
//                9985,
//                9986,
//                9988,
//                9990,
//                9990,
//                9993,
//                9994,
//                9995,
//                9996,
//                9997,
//                10000};
//        int s = 0;
//        int start = 3, end = 75;
//        for (int i = start;i <= end; ++i) {
//            s += (arr[end] - arr[i]);
//        }
//        System.out.println(">>>>> s = " + s);
    }

}

/**
Link: https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/

元素的频数是该元素在一个数组中出现的次数。
给你一个整数数组nums和一个整数k。在一步操作中，你可以选择nums的一个下标，并将该下标对应元素的值增加1。
执行最多k次操作后，返回数组中最高频元素的最大可能频数。

示例1：
输入：nums = [1, 2, 4], k = 5
输出：3
解释：对第一个元素执行3次递增操作，对第二个元素执2次递增操作，此时nums = [4, 4, 4]。
4是数组中最高频元素，频数是3。

示例2：
输入：nums = [1, 4, 8, 13], k = 5
输出：2
解释：存在多种最优解决方案：
- 对第一个元素执行3次递增操作，此时 nums = [4, 4, 8, 13] 。4 是数组中最高频元素，频数是 2 。
- 对第二个元素执行4次递增操作，此时 nums = [1, 8, 8, 13] 。8 是数组中最高频元素，频数是 2 。
- 对第三个元素执行5次递增操作，此时 nums = [1, 4, 13, 13] 。13 是数组中最高频元素，频数是 2 。

示例3：
输入：nums = [3, 9, 6], k = 2
输出：1

提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= 10^5

*/