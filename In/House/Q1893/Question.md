<h1>检查是否区域内所有整数都被覆盖</h1>

给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [start[i], end[i]]表示一个从start[i]到end[i]的闭区间。</br>
如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。</br>
已知区间ranges[i] = [start[i], end[i]] ，如果整数x满足start[i] <= x <= end[i]，那么我们称整数x被覆盖了。</br>

示例1：</br>
输入：ranges = [[1, 2], [3, 4], [5, 6]], left = 2, right = 5</br>
输出：true</br>
解释：2到5的每个整数都被覆盖了：</br>
- 2被第一个区间覆盖。</br>
- 3和4被第二个区间覆盖。</br>
- 5被第三个区间覆盖。</br>

示例2：</br>
输入：ranges = [[1, 10], [10, 20]], left = 21, right = 21</br>
输出：false</br>
解释：21没有被任何一个区间覆盖。</br>

提示：
- 1 <= ranges.length <= 50
- 1 <= start[i] <= end[i] <= 50
- 1 <= left <= right <= 50

[Link](https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/)