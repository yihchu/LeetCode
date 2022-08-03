<h1>你能在你最喜欢的那天吃到你最喜欢的糖果吗？</h1>

给你一个下标从0开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。同时给你一个二维数组queries，其中queries[i] = [favoriteType[i], favoriteDay[i], dailyCap[i]]。</br>
你按照如下规则进行一场游戏：</br>
你从第0天开始吃糖果。</br>
你在吃完所有第i - 1类糖果之前，不能吃任何一颗第i类糖果。</br>
在吃完所有糖果之前，你必须每天至少吃一颗糖果。</br>
请你构建一个布尔型数组answer，满足answer.length == queries.length。answer[i]为true的条件是：在每天吃不超过dailyCap[i]颗糖果的前提下，你可以在第favoriteDay[i]天吃到第favoriteType[i]类糖果；否则answer[i]为false。注意，只要满足上面3条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。</br>
请你返回得到的数组answer。</br>

示例1：</br>
输入：candiesCount = [7, 4, 5, 3, 8], queries = [[0, 2, 2], [4, 2, 4], [2, 13, 1000000000]]</br>
输出：[true, false, true]</br>
提示：</br>
1- 在第0天吃2颗糖果(类型0），第1天吃2颗糖果（类型0），第2天你可以吃到类型0的糖果。</br>
2- 每天你最多吃4颗糖果。即使第0天吃4颗糖果（类型0），第1天吃4颗糖果（类型0和类型1），你也没办法在第2天吃到类型4的糖果。换言之，你没法在每天吃4颗糖果的限制下在第2天吃到第4类糖果。</br>
3- 如果你每天吃1颗糖果，你可以在第13天吃到类型2的糖果。</br>

示例2：</br>
输入：candiesCount = [5, 2, 6, 4, 1], queries = [[3, 1, 2], [4, 10, 3], [3, 10, 100], [4, 100, 30], [1, 3, 1]]</br>
输出：[false, true, true, false, false]</br>

提示：
- 1 <= candiesCount.length <= 10^5
- 1 <= candiesCount[i] <= 10^5
- 1 <= queries.length <= 10^5
- queries[i].length == 3
- 0 <= favoriteType[i] < candiesCount.length
- 0 <= favoriteDay[i] <= 10^9
- 1 <= dailyCap[i] <= 10^9

[Link](https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/)