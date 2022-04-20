<h1>IPO</h1>

假设力扣（LeetCode）即将开始IPO。为了以更高的价格将股票卖给风险投资公司，力扣希望在IPO之前开展一些项目以增加其资本。由于资源有限，它只能在IPO之前完成最多k个不同的项目。帮助力扣设计完成最多k个不同项目后得到最大总资本的方式。</br>
给你n个项目。对于每个项目i，它都有一个纯利润profits[i]，和启动该项目需要的最小资本capital[i]。</br>
最初，你的资本为w。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。</br>
总而言之，从给定项目中选择最多k个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。</br>
答案保证在32位有符号整数范围内。</br>

示例1：</br>
输入：k = 2, w = 0, profits = [1, 2, 3], capital = [0, 1, 1]</br>
输出：4</br>
解释：</br>
由于你的初始资本为0，你仅可以从0号项目开始。</br>
在完成后，你将获得1的利润，你的总资本将变为1。</br>
此时你可以选择开始1号或2号项目。</br>
由于你最多可以选择两个项目，所以你需要完成2号项目以获得最大的资本。</br>
因此，输出最后最大化的资本，为0 + 1 + 3 = 4。</br>

示例2：</br>
输入：k = 3, w = 0, profits = [1, 2, 3], capital = [0, 1, 2]</br>
输出：6</br>

提示：</br>
1 <= k <= 10^5</br>
0 <= w <= 10^9</br>
n == profits.length</br>
n == capital.length</br>
1 <= n <= 10^5</br>
0 <= profits[i] <= 10^4</br>
0 <= capital[i] <= 10^9</br>

[Link](https://leetcode-cn.com/problems/ipo/)