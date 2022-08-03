<h1>反转字符串II</h1>

给定一个字符串s和一个整数k，从字符串开头算起，每2k个字符反转前k个字符。</br>
如果剩余字符少于k个，则将剩余字符全部反转。</br>
如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样。</br>

示例1：</br>
输入：s = "abcdefg", k = 2</br>
输出："bacdfeg"</br>

示例2：</br>
输入：s = "abcd", k = 2</br>
输出："bacd"</br>

提示：
- 1 <= s.length <= 10^4
- s仅由小写英文组成
- 1 <= k <= 10^4

[Link](https://leetcode-cn.com/problems/reverse-string-ii/)