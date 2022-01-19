package In.House.Q26;

public class Solution {

    public void move(int[] nums, int start, int end) {
        for (int i = start; i + 1< end; ++i) {
            nums[i] = nums[i + 1];
        }
    }
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int current = nums[0];
        int count = 0;
        for (int i = 1; i < len - count; ) {
            if (nums[i] == current) {
                move(nums, i, len - count);
                ++count;
            } else {
                current = nums[i];
                ++i;
            }
        }
        return len - count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[] array1 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result1 = slt.removeDuplicates(array1);
        for (int i = 0; i < result1; ++i) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
    }
}

/**
Ques:
Link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

给你一个有序数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。

说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
//nums是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

示例1：
输入：nums = [1, 1, 2]
输出：2, nums = [1, 2]
解释：函数应该返回新的长度2，并且原数组nums的前两个元素被修改为1, 2。不需要考虑数组中超出新长度后面的元素。

示例2：
输入：nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
输出：5, nums = [0, 1, 2, 3, 4]
解释：函数应该返回新的长度5，并且原数组nums的前五个元素被修改为0, 1, 2, 3, 4。不需要考虑数组中超出新长度后面的元素。

提示：
0 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
nums已按升序排列

*/
