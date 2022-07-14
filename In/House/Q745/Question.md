<h1>前缀和后缀搜索</h1>

设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。</br>
实现WordFilter类：</br>
WordFilter(string[] words)使用词典中的单词words初始化对象。</br>
f(string pref, string suff)返回词典中具有前缀prefix和后缀suff的单词的下标。如果存在不止一个满足要求的下标，返回其中最大的下标。如果不存在这样的单词，返回-1。</br>

示例：</br>
输入</br>
["WordFilter", "f"]</br>
[[["apple"]], ["a", "e"]]</br>
输出</br>
[null, 0]</br>
解释</br>
WordFilter wordFilter = new WordFilter(["apple"]);</br>
wordFilter.f("a", "e"); // 返回0，因为下标为0的单词：前缀prefix = "a"且后缀suff = "e"。</br>

提示：
- 1 <= words.length <= 10^4
- 1 <= words[i].length <= 7
- 1 <= pref.length, suff.length <= 7
- words[i]、pref和suff仅由小写英文字母组成
- 最多对函数f执行10^4次调用

[link](https://leetcode.cn/problems/prefix-and-suffix-search/)