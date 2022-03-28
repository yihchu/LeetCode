<h1>句子中的有效单词数</h1>

句子仅由小写字母（'a'到'z'）、数字（'0'到'9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成一个或者多个token，这些token之间由一个或者多个空格' '分隔。</br>
如果一个token同时满足下述条件，则认为这个token是一个有效单词：</br>
仅由小写字母、连字符和/或标点（不含数字）。</br>
至多一个连字符'-'。如果存在，连字符两侧应当都存在小写字母（"a-b"是一个有效单词，但"-ab"和"ab-"不是有效单词）。</br>
至多一个标点符号。如果存在，标点符号应当位于token的末尾。</br>
这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!"。</br>
给你一个字符串sentence，请你找出并返回sentence中有效单词的数目。</br>

示例1：</br>
输入：sentence = "cat and  dog"</br>
输出：3</br>
解释：句子中的有效单词是"cat"、"and"和"dog"</br>

示例2：</br>
输入：sentence = "!this  1-s b8d!"</br>
输出：0</br>
解释：句子中没有有效单词</br>
"!this"不是有效单词，因为它以一个标点开头</br>
"1-s"和"b8d"也不是有效单词，因为它们都包含数字</br>

示例3：</br>
输入：sentence = "alice and  bob are playing stone-game10"</br>
输出：5</br>
解释：句子中的有效单词是"alice"、"and"、"bob"、"are"和"playing"</br>
"stone-game10"不是有效单词，因为它含有数字</br>

示例4：</br>
输入：sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."</br>
输出：6</br>
解释：句子中的有效单词是"he"、"bought"、"pencils,"、"erasers,"、"and" 和 "pencil-sharpener."</br>

提示：</br>
1 <= sentence.length <= 1000</br>
sentence由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成</br>
句子中至少有1个token</br>

[Link](https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/)