<h1>重复叠加字符串匹配</h1>

给定两个字符串a和b，寻找重复叠加字符串a的最小次数，使得字符串b成为叠加后的字符串a的子串，如果不存在则返回-1。
注意：字符串"abc"重复叠加0次是""，重复叠加1次是"abc"，重复叠加2次是"abcabc"。</br>

示例1：</br>
输入：a = "abcd", b = "cdabcdab"</br>
输出：3</br>
解释：a重复叠加三遍后为"abcdabcdabcd", 此时b是其子串。</br>

示例2：</br>
输入：a = "a", b = "aa"</br>
输出：2</br>

示例3：</br>
输入：a = "a", b = "a"</br>
输出：1</br>

示例4：</br>
输入：a = "abc", b = "wxyz"</br>
输出：-1</br>

提示：</br>
1 <= a.length <= 10^4</br>
1 <= b.length <= 10^4</br>
a和b由小写英文字母组成</br>

[Link](https://leetcode-cn.com/problems/repeated-string-match/)