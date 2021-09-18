package sword.to.offer;

import java.util.Arrays;

public class LT53 {

    public int search(int[] nums, int target) {
        return (int)Arrays.stream(nums).filter(n -> n == target).count();
    }

    public static void main(String[] args) {
        LT53 lt53 = new LT53();
        System.out.println(lt53.search(new int[]{5, 7, 7, 8, 8, 10}, 8)); // 2
        System.out.println(lt53.search(new int[]{5, 7, 7, 8, 8, 10}, 6)); // 0
    }

}

/**
Link: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

统计一个数字在排序数组中出现的次数。

示例1:
输入: nums = [5, 7, 7, 8, 8, 10], target = 8
输出: 2

示例2:
输入: nums = [5, 7, 7, 8, 8, 10], target = 6
输出: 0

限制：
0 <= 数组长度 <= 50000

*/