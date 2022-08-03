<h1>按权重随机选择</h1>

给定一个正整数数组w，其中w[i]代表下标i的权重（下标从0开始），请写一个函数pickIndex，它可以随机地获取下标i，选取下标i的概率与w[i]成正比。</br>
例如，对于w = [1, 3]，挑选下标0的概率为1 / (1 + 3) = 0.25 （即，25%），而选取下标1的概率为3 / (1 + 3) = 0.75（即，75%）。</br>
也就是说，选取下标i的概率为w[i] / sum(w)。</br>

示例1：</br>
输入：</br>
["Solution","pickIndex"]</br>
[[[1]], []]</br>
输出：</br>
[null, 0]</br>
解释：</br>
Solution solution = new Solution([1]);</br>
solution.pickIndex(); // 返回0，因为数组中只有一个元素，所以唯一的选择是返回下标0。</br>

示例2：</br>
输入：</br>
["Solution", "pickIndex", "pickIndex", "pickIndex", "pickIndex", "pickIndex"]</br>
[[[1, 3]], [], [], [], [], []]</br>
输出：</br>
[null, 1, 1, 1, 1, 0]</br>
解释：</br>
Solution solution = new Solution([1, 3]);</br>
solution.pickIndex(); // 返回1，返回下标1，返回该下标概率为3/4。</br>
solution.pickIndex(); // 返回1</br>
solution.pickIndex(); // 返回1</br>
solution.pickIndex(); // 返回1</br>
solution.pickIndex(); // 返回0，返回下标0，返回该下标概率为1/4。</br>

由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:</br>
[null, 1, 1, 1, 1, 0]</br>
[null, 1, 1, 1, 1, 1]</br>
[null, 1, 1, 1, 0, 0]</br>
[null, 1, 1, 1, 0, 1]</br>
[null, 1, 0, 1, 0, 0]</br>
......</br>
诸若此类。</br>

提示：
- 1 <= w.length <= 10000
- 1 <= w[i] <= 10^5
- pickIndex将被调用不超过10000次

[Link](https://leetcode-cn.com/problems/random-pick-with-weight/)