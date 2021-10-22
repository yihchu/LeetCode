import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT229 {


    /**
     * O(n)的解法，在官方题解中，使用的是摩尔投票法~
     * 我肯定是想不到哇~
     */



    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int thres = len / 3;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len ; ++i) {
            int count = map.getOrDefault(nums[i], 0);
            if (count < 0) {
                continue;
            }
            if (count >= thres) {
                result.add(nums[i]);
                map.put(nums[i], -1);
            } else {
                map.put(nums[i], count + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LT229 lt229 = new LT229();
        lt229.majorityElement(new int[] {3, 2, 3}).forEach(a -> System.out.print(a + " "));
        System.out.println();
        lt229.majorityElement(new int[] {1}).forEach(a -> System.out.print(a + " "));
        System.out.println();
        lt229.majorityElement(new int[] {1, 1, 1, 3, 3, 2, 2, 2}).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/majority-element-ii/

给定一个大小为n的整数数组，找出其中所有出现超过⌊n/3⌋次的元素。

示例1：
输入：[3, 2, 3]
输出：[3]

示例2：
输入：nums = [1]
输出：[1]

示例3：
输入：[1, 1, 1, 3, 3, 2, 2, 2]
输出：[1, 2]

提示：
1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

*/