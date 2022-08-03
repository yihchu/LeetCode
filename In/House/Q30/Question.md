<h1>串联所有单词的子串</h1>

给定一个字符串s和一些长度相同的单词words。找出s中恰好可以由words中所有单词串联形成的子串的起始位置。</br>
注意子串要与words中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。</br>

示例1：</br>
输入：s = "barfoothefoobarman", words = ["foo", "bar"]</br>
输出：[0, 9]</br>
解释：</br>
从索引0和9开始的子串分别是"barfoo"和"foobar"。</br>
输出的顺序不重要, [9, 0]也是有效答案。</br>

示例2：</br>
输入：s = "wordgoodgoodgoodbestword", words = ["word", "good", "best", "word"]</br>
输出：[]</br>

示例3：</br>
输入：s = "barfoofoobarthefoobarman", words = ["bar", "foo", "the"]</br>
输出：[6, 9, 12]</br>

提示：
- 1 <= s.length <= 10^4
- s由小写英文字母组成
- 1 <= words.length <= 5000
- 1 <= words[i].length <= 30
- words[i]由小写英文字母组成

[Link](https://leetcode.cn/problems/substring-with-concatenation-of-all-words/)