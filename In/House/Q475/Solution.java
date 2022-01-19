package In.House.Q475;

import java.util.Arrays;

public class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int hsIdx = 0, htIdx = 0;
        int left = -1, right = heaters[htIdx];
        int radius = 0;
        while (hsIdx < houses.length) {
            if (houses[hsIdx] <= right) {
                radius = Math.max(radius, left < 0
                        ? (right - houses[hsIdx])
                        : Math.min(houses[hsIdx] - left, right - houses[hsIdx]));
                ++hsIdx;
                continue;
            }
            ++htIdx;
            left = right;
            right = htIdx < heaters.length ? heaters[htIdx] : Integer.MAX_VALUE;
        }
        return radius;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.findRadius(new int[] {1, 2, 3}, new int[] {2})); // 1
//        System.out.println(slt.findRadius(new int[] {1, 2, 3, 4}, new int[] {1, 4})); // 1
//        System.out.println(slt.findRadius(new int[] {1, 5}, new int[] {2})); // 3
        System.out.println(slt.findRadius(
                new int[] {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[] {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612})); // 3
    }

}

/**
Ques: 供暖器
Link: https://leetcode-cn.com/problems/heaters/

冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
在加热器的加热半径范围内的每个房屋都可以获得供暖。
现在，给出位于一条水平线上的房屋houses和供暖器heaters的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
说明：所有供暖器都遵循你的半径标准，加热的半径也一样。

示例1:
输入: houses = [1, 2, 3], heaters = [2]
输出: 1
解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。

示例2:
输入: houses = [1, 2, 3, 4], heaters = [1, 4]
输出: 1
解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。

示例3：
输入：houses = [1, 5], heaters = [2]
输出：3

提示：
1 <= houses.length, heaters.length <= 3 * 10^4
1 <= houses[i], heaters[i] <= 10^9

*/