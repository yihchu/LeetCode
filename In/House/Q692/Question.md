<h1>前K个高频单词</h1>

给一非空的单词列表，返回前k个出现次数最多的单词。</br>
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。</br>

示例1：</br>
输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2</br>
输出: ["i", "love"]</br>
解析: "i"和"love"为出现次数最多的两个单词，均为2次。注意，按字母顺序"i" 在 "love"之前。</br>

示例2：</br>
输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4</br>
输出: ["the", "is", "sunny", "day"]</br>
解析: "the", "is", "sunny"和"day"是出现次数最多的四个单词，出现次数依次为4, 3, 2和1次。</br>

注意：</br>
假定k总为有效值，1 ≤ k ≤ 集合元素数。</br>
输入的单词均由小写字母组成。</br>

扩展练习：</br>
尝试以O(nlogk)时间复杂度和O(n)空间复杂度解决。</br>

[Link](https://leetcode-cn.com/problems/top-k-frequent-words/)