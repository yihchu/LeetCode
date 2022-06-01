<h1>火柴拼正方形</h1>

你将得到一个整数数组matchsticks，其中matchsticks[i]是第i个火柴棒的长度。你要用所有的火柴棍拼成一个正方形。你不能折断任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须使用一次。</br>
如果你能使这个正方形，则返回true，否则返回false。</br>

示例1:</br>
</br>![](./image/1.jpeg)</br></br>
输入: matchsticks = [1, 1, 2, 2, 2]</br>
输出: true</br>
解释: 能拼成一个边长为2的正方形，每边两根火柴。</br>

示例2:</br>
输入: matchsticks = [3, 3, 3, 3, 4]</br>
输出: false</br>
解释: 不能用所有火柴拼成一个正方形。</br>

提示:</br>
1 <= matchsticks.length <= 15</br>
1 <= matchsticks[i] <= 10^8</br>

[Link](https://leetcode.cn/problems/matchsticks-to-square/)