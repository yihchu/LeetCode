<h1>增减字符串匹配</h1>

由范围[0, n]内所有整数组成的n + 1个整数的排列序列可以表示为长度为n的字符串s，其中:</br>
如果perm[i] < perm[i + 1]，那么 s[i] == 'I'</br>
如果perm[i] > perm[i + 1]，那么 s[i] == 'D'</br>
给定一个字符串s，重构排列perm并返回它。如果有多个有效排列perm，则返回其中任何一个。</br>

示例1：</br>
输入：s = "IDID"</br>
输出：[0, 4, 1, 3, 2]</br>

示例2：</br>
输入：s = "III"</br>
输出：[0, 1, 2, 3]</br>

示例3：</br>
输入：s = "DDI"</br>
输出：[3, 2, 0, 1]</br>

提示：
- 1 <= s.length <= 10^5
- s只包含字符"I"或"D"

[Link](https://leetcode.cn/problems/di-string-match/)