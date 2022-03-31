<h1>相对名次</h1>

给你一个长度为n的整数数组score，其中score[i]是第i位运动员在比赛中的得分。所有得分都互不相同。</br>
运动员将根据得分决定名次，其中名次第1的运动员得分最高，名次第2的运动员得分第2高，依此类推。运动员的名次决定了他们的获奖情况：</br>
名次第1的运动员获金牌"Gold Medal"。</br>
名次第2的运动员获银牌"Silver Medal"。</br>
名次第3的运动员获铜牌"Bronze Medal"。</br>
从名次第4到第n的运动员，只能获得他们的名次编号（即，名次第x的运动员获得编号"x"）。</br>
使用长度为n的数组answer返回获奖，其中answer[i]是第i位运动员的获奖情况。</br>

示例1：</br>
输入：score = [5, 4, 3, 2, 1]</br>
输出：["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]</br>
解释：名次为 [1st, 2nd, 3rd, 4th, 5th]。</br>

示例2：</br>
输入：score = [10, 3, 8, 9, 4]</br>
输出：["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]</br>
解释：名次为 [1st, 5th, 3rd, 2nd, 4th]。</br>

提示：</br>
n == score.length</br>
1 <= n <= 10^4</br>
0 <= score[i] <= 10^6</br>
score中的所有值互不相同</br>

[Link](https://leetcode-cn.com/problems/relative-ranks/)