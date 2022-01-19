package In.House.Q495;

public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisoned = timeSeries[0] + duration;
        int result = duration, len = timeSeries.length;
        for (int i = 1; i < len; ++i) {
            result += (timeSeries[i] < poisoned ? duration - (poisoned - timeSeries[i]) : duration);
            poisoned = timeSeries[i] + duration;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findPoisonedDuration(new int[] {1, 4}, 2)); // 4
        System.out.println(slt.findPoisonedDuration(new int[] {1, 2}, 2)); // 3
        System.out.println(slt.findPoisonedDuration(new int[] {1, 2, 3, 4, 5}, 5)); // 9
    }
}

/**
Ques: 提莫攻击
Link: https://leetcode-cn.com/problems/teemo-attacking/

在《英雄联盟》的世界中，有一个叫“提莫”的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
当提莫攻击艾希，艾希的中毒状态正好持续duration秒。
正式地讲，提莫在t发起发起攻击意味着艾希在时间区间[t, t + duration - 1]（含t和t + duration - 1）处于中毒状态。如果提莫在中毒影响结束前再次攻击，中毒状态计时器将会重置，在新的攻击之后，中毒影响将会在duration秒后结束。
给你一个非递减的整数数组timeSeries，其中timeSeries[i]表示提莫在timeSeries[i]秒时对艾希发起攻击，以及一个表示中毒持续时间的整数duration。
返回艾希处于中毒状态的总秒数。

示例1：
输入：timeSeries = [1, 4], duration = 2
输出：4
解释：提莫攻击对艾希的影响如下：
- 第1秒，提莫攻击艾希并使其立即中毒。中毒状态会维持2秒，即第1秒和第2秒。
- 第4秒，提莫再次攻击艾希，艾希中毒状态又持续2秒，即第4秒和第5秒。
艾希在第1、2、4、5秒处于中毒状态，所以总中毒秒数是4。

示例2：
输入：timeSeries = [1, 2], duration = 2
输出：3
解释：提莫攻击对艾希的影响如下：
- 第1秒，提莫攻击艾希并使其立即中毒。中毒状态会维持2秒，即第1秒和第2秒。
- 第2秒，提莫再次攻击艾希，并重置中毒计时器，艾希中毒状态需要持续2秒，即第2秒和第3秒。
艾希在第1、2、3秒处于中毒状态，所以总中毒秒数是3。

提示：
1 <= timeSeries.length <= 10^4
0 <= timeSeries[i], duration <= 10^7
timeSeries按非递减顺序排列

*/