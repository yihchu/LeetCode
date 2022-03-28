<h1>词典中最长的单词</h1>

给出一个字符串数组words组成的一本英语词典。返回words中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。</br>
若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。</br>

示例1：</br>
输入：words = ["w", "wo", "wor", "worl", "world"]</br>
输出："world"</br>
解释：单词"world"可由"w", "wo", "wor", 和"worl"逐步添加一个字母组成。</br>

示例2：</br>
输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]</br>
输出："apple"</br>
解释："apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"</br>

提示：</br>
1 <= words.length <= 1000</br>
1 <= words[i].length <= 30</br>
所有输入的字符串words[i]都只包含小写字母。</br>

[Link](https://leetcode-cn.com/problems/longest-word-in-dictionary/)