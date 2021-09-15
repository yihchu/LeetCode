public class LT162 {

    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (start == end) {
            return 0;
        }
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else if (mid <= end - 1 && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LT162 lt162 = new LT162();
        System.out.println(lt162.findPeakElement(new int[] {1, 2, 3, 1})); // 2
        System.out.println(lt162.findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4})); // 1 or 5
        System.out.println(lt162.findPeakElement(new int[] {1, 2})); // 1
    }

}

/*

峰值元素是指其值严格大于左右相邻值的元素。
给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
你可以假设nums[-1] = nums[n] = -∞ 。
你必须实现时间复杂度为O(logn)的算法来解决此问题。

示例 1：
输入：nums = [1, 2, 3, 1]
输出：2
解释：3是峰值元素，你的函数应该返回其索引2。

示例2：
输入：nums = [1, 2, 1, 3, 5, 6, 4]
输出：1或5
解释：你的函数可以返回索引1，其峰值元素为2；或者返回索引5，其峰值元素为6。

提示：
1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
对于所有有效的i都有nums[i] != nums[i + 1]

*/