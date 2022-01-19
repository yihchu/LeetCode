package In.House.Q846;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length, count = len / groupSize;
        if (len % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; ++i) {
            queue.add(hand[i]);
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for (int i = 0; i < count; ++i) {
            int min = queue.peek();
            for (int j = 0; j < groupSize; ++j) {
                if (!map.containsKey(min)) {
                    return false;
                }
                int c = map.get(min);
                if (c == 1) {
                    map.remove(min);
                } else {
                    map.put(min, c - 1);
                }
                queue.remove(min);
                ++min;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isNStraightHand(new int[] {1, 2, 3, 6, 2, 3, 4, 7, 8}, 3)); // true
        System.out.println(slt.isNStraightHand(new int[] {1, 2, 3, 6, 2, 3, 4, 6, 8}, 3)); // false
        System.out.println(slt.isNStraightHand(new int[] {1, 2, 3, 4, 5}, 4)); // false
        System.out.println(slt.isNStraightHand(new int[] {8, 10, 12}, 3)); // false
    }

}


/**
Ques: 一手顺子
Link: https://leetcode-cn.com/problems/hand-of-straights/

Alice手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是groupSize，并且由groupSize张连续的牌组成。
给你一个整数数组hand其中hand[i]是写在第i张牌，和一个整数groupSize。如果她可能重新排列这些牌，返回true；否则，返回false。

示例1：
输入：hand = [1, 2, 3, 6, 2, 3, 4, 7, 8], groupSize = 3
输出：true
解释：Alice手中的牌可以被重新排列为[1, 2, 3]，[2, 3, 4]，[6, 7, 8]。

示例2：
输入：hand = [1, 2, 3, 4, 5], groupSize = 4
输出：false
解释：Alice手中的牌无法被重新排列成几个大小为4的组。

提示：
1 <= hand.length <= 10^4
0 <= hand[i] <= 10^9
1 <= groupSize <= hand.length

*/