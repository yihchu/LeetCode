<h1>亲密字符串</h1>

给你两个字符串s和goal，只要我们可以通过交换s中的两个字母得到与goal相等的结果，就返回true；否则返回false。</br>
交换字母的定义是：取两个下标i和j（下标从 0 开始）且满足i != j，接着交换s[i]和s[j]处的字符。</br>
例如，在"abcd"中交换下标0和下标2的元素可以生成"cbad"。</br>

示例1：</br>
输入：s = "ab", goal = "ba"</br>
输出：true</br>
解释：你可以交换s[0] = 'a'和s[1] = 'b'生成"ba"，此时s和goal相等。</br>

示例2：</br>
输入：s = "ab", goal = "ab"</br>
输出：false</br>
解释：你只能交换s[0] = 'a'和s[1] = 'b'生成"ba"，此时s和goal不相等。</br>

示例3：</br>
输入：s = "aa", goal = "aa"</br>
输出：true</br>
解释：你可以交换s[0] = 'a'和s[1] = 'a'生成"aa"，此时s和goal相等。</br>

示例4：</br>
输入：s = "aaaaaaabc", goal = "aaaaaaacb"</br>
输出：true</br>

提示：
- 1 <= s.length, goal.length <= 2 * 10^4
- s和goal由小写英文字母组成

[Link](https://leetcode-cn.com/problems/buddy-strings/)