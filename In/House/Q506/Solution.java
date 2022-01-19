package In.House.Q506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, String> dict = new HashMap<>() {{
        put(1, "Gold Medal");
        put(2, "Silver Medal");
        put(3, "Bronze Medal");
    }};

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        Map<Integer, Integer> map = new HashMap<>() {{
           for (int i = 0; i < len; ++i) {
               put(score[i], i);
           }
        }};
        Arrays.sort(score);
        String[] result = new String[len];
        for (int i = 0; i < len; ++i) {
            result[map.get(score[i])] = dict.getOrDefault(len - i, String.valueOf(len - i));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.findRelativeRanks(new int[] {5, 4, 3, 2, 1})).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(slt.findRelativeRanks(new int[] {10, 3, 8, 9, 4})).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }


}

/**
Ques: 相对名次
Link: https://leetcode-cn.com/problems/relative-ranks/

给你一个长度为n的整数数组score，其中score[i]是第i位运动员在比赛中的得分。所有得分都互不相同。
运动员将根据得分决定名次，其中名次第1的运动员得分最高，名次第2的运动员得分第2高，依此类推。运动员的名次决定了他们的获奖情况：
名次第1的运动员获金牌"Gold Medal"。
名次第2的运动员获银牌"Silver Medal"。
名次第3的运动员获铜牌"Bronze Medal"。
从名次第4到第n的运动员，只能获得他们的名次编号（即，名次第x的运动员获得编号"x"）。
使用长度为n的数组answer返回获奖，其中answer[i]是第i位运动员的获奖情况。

示例1：
输入：score = [5, 4, 3, 2, 1]
输出：["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释：名次为 [1st, 2nd, 3rd, 4th, 5th]。

示例2：
输入：score = [10, 3, 8, 9, 4]
输出：["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
解释：名次为 [1st, 5th, 3rd, 2nd, 4th]。

提示：
n == score.length
1 <= n <= 10^4
0 <= score[i] <= 10^6
score中的所有值互不相同

*/