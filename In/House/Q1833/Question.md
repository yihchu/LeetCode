<h1>雪糕的最大数量</h1>

夏日炎炎，小男孩Tony想买一些雪糕消消暑。</br>
商店中新到n支雪糕，用长度为n的数组costs表示雪糕的定价，其中costs[i]表示第i支雪糕的现金价格。Tony一共有coins现金可以用于消费，他想要买尽可能多的雪糕。</br>
给你价格数组costs和现金量coins，请你计算并返回Tony用coins现金能够买到的雪糕的最大数量。</br>

注意：Tony可以按任意顺序购买雪糕。</br>

示例1：</br>
输入：costs = [1, 3, 2, 4, 1], coins = 7</br>
输出：4</br>
解释：Tony可以买下标为0、1、2、4的雪糕，总价为1 + 3 + 2 + 1 = 7</br>

示例2：</br>
输入：costs = [10, 6, 8, 7, 7, 8], coins = 5</br>
输出：0</br>
解释：Tony没有足够的钱买任何一支雪糕。</br>

示例3：</br>
输入：costs = [1, 6, 3, 1, 2, 5], coins = 20</br>
输出：6</br>
解释：Tony可以买下所有的雪糕，总价为1 + 6 + 3 + 1 + 2 + 5 = 18。</br>

提示：</br>
costs.length == n</br>
1 <= n <= 10^5</br>
1 <= costs[i] <= 10^5</br>
1 <= coins <= 10^8</br>

[Link](https://leetcode-cn.com/problems/maximum-ice-cream-bars/)