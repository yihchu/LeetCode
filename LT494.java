public class LT494 {

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        return findTargetSumWays(nums, len - 1, target);
    }

    public int findTargetSumWays(int[] nums, int end, int target) {
        if (end == 0) {
            int sum = nums[0] == target ? 1 : 0;
            sum += 0 - nums[0] == target ? 1 : 0;
            return sum;
        }
        return findTargetSumWays(nums, end - 1, target + nums[end])
                + findTargetSumWays(nums, end - 1, target - nums[end]);
    }

    public static void main(String[] args) {
        LT494 lt494 = new LT494();
        System.out.println(lt494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(lt494.findTargetSumWays(new int[]{1}, 1)); // 1
        System.out.println(lt494.findTargetSumWays(new int[]{0, 1}, 1)); //
        System.out.print(lt494.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)); // 256
    }
}

/*

给你一个整数数组nums和一个整数target。

向数组中的每个整数前添加'+'或'-'，然后串联起所有整数，可以构造一个表达式 ：

例如，nums = [2, 1]，可以在2之前添加'+'，在1之前添加'-'，然后串联起来得到表达式"+2-1" 。
返回可以通过上述方法构造的、运算结果等于target的不同表达式的数目。

示例 1：
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有5种方法让最终目标和为3。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

示例 2：
输入：nums = [1], target = 1
输出：1

提示：

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 100

*/