<h1>环绕字符串中唯一的子字符串</h1>

把字符串s看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以s看起来是这样的：</br>
"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".</br>
现在给定另一个字符串p。返回s中唯一的p的非空子串的数量。</br>

示例1:</br>
输入: p = "a"</br>
输出: 1</br>
解释: 字符串s中只有一个"a"子字符。</br>

示例2:</br>
输入: p = "cac"</br>
输出: 2</br>
解释: 字符串s中的字符串“cac”只有两个子串“a”、“c”。.</br>

示例3:</br>
输入: p = "zab"</br>
输出: 6</br>
解释: 在字符串s中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。</br>

提示:
- 1 <= p.length <= 10^5
- p由小写英文字母构成

[Link](https://leetcode.cn/problems/unique-substrings-in-wraparound-string/)