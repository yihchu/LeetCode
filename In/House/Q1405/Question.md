<h1>最长快乐字符串</h1>

如果字符串中不含有任何'aaa'，'bbb'或'ccc'这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。</br>
给你三个整数a，b，c请你返回任意一个满足下列全部条件的字符串s：</br>
s是一个尽可能长的快乐字符串。</br>
s中最多有a个字母'a'、b个字母'b'、c个字母'c'。</br>
s中只含有'a'、'b' 、'c'三种字母。</br>
如果不存在这样的字符串s，请返回一个空字符串""。</br>

示例1：</br>
输入：a = 1, b = 1, c = 7</br>
输出："ccaccbcc"</br>
解释："ccbccacc"也是一种正确答案。</br>

示例2：</br>
输入：a = 2, b = 2, c = 1</br>
输出："aabbc"</br>

示例3：</br>
输入：a = 7, b = 1, c = 0</br>
输出："aabaa"</br>
解释：这是该测试用例的唯一正确答案。</br>

提示：</br>
0 <= a, b, c <= 100</br>
a + b + c > 0</br>

[Link](https://leetcode-cn.com/problems/longest-happy-string/)