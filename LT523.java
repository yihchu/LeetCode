import java.util.HashMap;
import java.util.Map;

public class LT523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        m.putIfAbsent(nums[0] % k, 0);
        for (int i = 1; i < len; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 1; i < len; ++i) {
            int mod = nums[i] % k;
            if (m.containsKey(mod)) {
                if (i - m.get(mod) > 1) {
                    return true;
                }
            }
            m.putIfAbsent(mod, i);
        }
        return false;
    }

    public static void main(String[] args) {
        LT523 lt523 = new LT523();
        System.out.println(lt523.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(lt523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
        System.out.println(lt523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)); // false
        System.out.println(lt523.checkSubarraySum(new int[]{1, 0}, 2)); // false
        System.out.println(lt523.checkSubarraySum(new int[]{5, 0, 0, 0, 0}, 3)); // true
        System.out.println(lt523.checkSubarraySum(new int[]{1, 2, 3}, 5)); // true
        System.out.println(lt523.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7)); // true
        System.out.println(lt523.checkSubarraySum(new int[]{0, 0}, 1)); // true
    }
}

/**
Link: https://leetcode-cn.com/problems/continuous-subarray-sum/

给你一个整数数组nums和一个整数k，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
子数组大小至少为2，且
子数组元素总和为k的倍数。
如果存在，返回true；否则，返回false。
如果存在一个整数n，令整数x符合x = n * k，则称x是k的一个倍数。

示例 1：
输入：nums = [23, 2, 4, 6, 7], k = 6
输出：true
解释：[2, 4]是一个大小为2的子数组，并且和为6。

示例2：
输入：nums = [23, 2, 6, 4, 7], k = 6
输出：true
解释：[23, 2, 6, 4, 7]是大小为5的子数组，并且和为42。
42是6的倍数，因为42 = 7 * 6且7是一个整数。

示例3：
输入：nums = [23, 2, 6, 4, 7], k = 13
输出：false

提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= sum(nums[i]) <= 2^31 - 1
1 <= k <= 2^31 - 1
*/