package In.House.Q11;

public class Solution {

    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        while (r > l) {
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(slt.maxArea(new int[] {1, 1})); // 1
        System.out.println(slt.maxArea(new int[] {4, 3, 2, 1, 4})); // 16
        System.out.println(slt.maxArea(new int[] {1, 2, 1})); // 2
    }

}

/**
Link: https://leetcode-cn.com/problems/container-with-most-water/

给你n个非负整数a[1]，a[2]，...，a[n]，每个数代表坐标中的一个点(i, a[i])。在坐标内画n条垂直线，垂直线i的两个端点分别为(i, a[i])和(i, 0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器。

示例1(图1.jpg)：
输入：[1, 8, 6, 2, 5, 4, 8, 3, 7]
输出：49
解释：图中垂直线代表输入数组[1, 8, 6, 2, 5, 4, 8, 3, 7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。

示例2：
输入：height = [1, 1]
输出：1

示例3：
输入：height = [4, 3, 2, 1, 4]
输出：16

示例4：
输入：height = [1, 2, 1]
输出：2

提示：
n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4

*/