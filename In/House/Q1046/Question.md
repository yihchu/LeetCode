/**
Ques: 最后一块石头的重量


有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为x和y，且x <= y。那么粉碎的可能结果如下：
如果x == y，那么两块石头都会被完全粉碎；
如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y - x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回0。

示例：
输入：[2, 7, 4, 1, 8, 1]
输出：1
解释：
先选出7和8，得到1，所以数组转换为[2, 4, 1, 1, 1]，
再选出2和4，得到2，所以数组转换为[2, 1, 1, 1]，
接着是2和1，得到1，所以数组转换为[1, 1, 1]，
最后选出1和1，得到0，最终数组转换为[1]，这就是最后剩下那块石头的重量。

提示：
1 <= stones.length <= 30
1 <= stones[i] <= 1000

[Link](https://leetcode-cn.com/problems/last-stone-weight/)