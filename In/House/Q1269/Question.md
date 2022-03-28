<h1>停在原地的方案数</h1>

有一个长度为arrLen的数组，开始有一个指针在索引0处。</br>
每一步操作中，你可以将指针向左或向右移动1步，或者停在原地（指针不能被移动到数组范围外）。</br>
给你两个整数steps和arrLen，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0处的方案数。</br>
由于答案可能会很大，请返回方案数模10^9 + 7后的结果。</br>

示例1：</br>
输入：steps = 3, arrLen = 2</br>
输出：4</br>
解释：3步后，总共有4种不同的方法可以停在索引0处。</br>
向右，向左，不动</br>
不动，向右，向左</br>
向右，不动，向左</br>
不动，不动，不动</br>

示例2：</br>
输入：steps = 2, arrLen = 4</br>
输出：2</br>
解释：2步后，总共有2种不同的方法可以停在索引0处。</br>
向右，向左</br>
不动，不动</br>

示例3：</br>
输入：steps = 4, arrLen = 2</br>
输出：8</br>

提示：</br>
1 <= steps <= 500</br>
1 <= arrLen<= 10^6</br>

[Link](https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/)