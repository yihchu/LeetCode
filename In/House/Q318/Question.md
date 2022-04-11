<h1>最大单词长度乘积</h1>

给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回0。</br>

示例1:</br>
输入: ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]</br>
输出: 16</br>
解释: 这两个单词为"abcw", "xtfn"。</br>

示例2:</br>
输入: ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]</br>
输出: 4</br>
解释: 这两个单词为"ab", "cd"。</br>

示例3:</br>
输入: ["a", "aa", "aaa", "aaaa"]</br>
输出: 0</br>
解释: 不存在这样的两个单词。</br>

提示：</br>
2 <= words.length <= 1000</br>
1 <= words[i].length <= 1000</br>
words[i]仅包含小写字母</br>

[Link](https://leetcode-cn.com/problems/maximum-product-of-word-lengths/)