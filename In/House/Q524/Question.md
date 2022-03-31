<h1>通过删除字母匹配到字典里最长单词</h1>

给你一个字符串s和一个字符串数组dictionary作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除s中的某些字符得到。</br>
如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。</br>

示例1：</br>
输入：s = "abpcplea", dictionary = ["ale", "apple", "monkey", "plea"]</br>
输出："apple"</br>

示例2：</br>
输入：s = "abpcplea", dictionary = ["a", "b", "c"]</br>
输出："a"</br>

提示：</br>
1 <= s.length <= 1000</br>
1 <= dictionary.length <= 1000</br>
1 <= dictionary[i].length <= 1000</br>
s和dictionary[i]仅由小写英文字母组成</br>

[Link](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)