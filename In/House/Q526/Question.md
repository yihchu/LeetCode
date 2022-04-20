<h1>优美的排列</h1>

假设有从1到N的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第i位(1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。</br>

条件：</br>
第i位的数字能被i整除</br>
i能被第i位上的数字整除</br>
现在给定一个整数N，请问可以构造多少个优美的排列？</br>

示例1:</br>
输入: 2</br>
输出: 2</br>

解释:</br>
第1个优美的排列是[1, 2]:</br>
第1个位置（i = 1）上的数字是1，1能被i（i = 1）整除</br>
第2个位置（i = 2）上的数字是2，2能被i（i = 2）整除</br>

第2个优美的排列是[2, 1]:</br>
第1个位置（i = 1）上的数字是2，2能被i（i = 1）整除</br>
第2个位置（i = 2）上的数字是1，i（i = 2）能被1整除</br>

说明:</br>
N是一个正整数，并且不会超过15。</br>

[Link](https://leetcode-cn.com/problems/beautiful-arrangement/)