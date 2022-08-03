<h1>航班预订统计</h1>

这里有n个航班，它们分别从1到n进行编号。</br>
有一份航班预订表bookings，表中第i条预订记录bookings[i] = [first[i], last[i], seats[i]]意味着在从first[i]到last[i]（包含first[i]和last[i]）的每个航班上预订了seats[i]个座位。</br>
请你返回一个长度为n的数组answer，其中answer[i]是航班i上预订的座位总数。</br>

示例1：</br>
输入：bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]], n = 5</br>
输出：[10, 55, 45, 25, 25]</br>
解释：</br>
航班编号        1   2   3   4   5</br>
预订记录 1 ：   10  10</br>
预订记录 2 ：       20  20</br>
预订记录 3 ：       25  25  25  25</br>
总座位数：      10  55  45  25  25</br>
因此，answer = [10, 55, 45, 25, 25]</br>

示例2：</br>
输入：bookings = [[1, 2, 10], [2, 2, 15]], n = 2</br>
输出：[10, 25]</br>
解释：</br>
航班编号        1   2</br>
预订记录 1 ：   10  10</br>
预订记录 2 ：       15</br>
总座位数：      10  25</br>
因此，answer = [10, 25]</br>

提示：
- 1 <= n <= 2 * 10^4
- 1 <= bookings.length <= 2 * 10^4
- bookings[i].length == 3
- 1 <= first[i] <= last[i] <= n
- 1 <= seats[i] <= 10^4

[Link](https://leetcode-cn.com/problems/corporate-flight-bookings/)
