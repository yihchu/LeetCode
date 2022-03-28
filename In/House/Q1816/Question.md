<h1>截断句子</h1>

句子是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。</br>
例如，"Hello World"、"HELLO"和"hello world hello world"都是句子。</br>
给你一个句子s和一个整数k，请你将s截断，使截断后的句子仅含前k个单词。返回截断s后得到的句子。</br>

示例1：</br>
输入：s = "Hello how are you Contestant", k = 4</br>
输出："Hello how are you"</br>
解释：</br>
s中的单词为["Hello", "how" "are", "you", "Contestant"]</br>
前4个单词为["Hello", "how", "are", "you"]</br>
因此，应当返回"Hello how are you"</br>

示例2：</br>
输入：s = "What is the solution to this problem", k = 4</br>
输出："What is the solution"</br>
解释：</br>
s中的单词为["What", "is" "the", "solution", "to", "this", "problem"]</br>
前4个单词为["What", "is", "the", "solution"]</br>
因此，应当返回"What is the solution"</br>

示例3：</br>
输入：s = "chopper is not a tanuki", k = 5</br>
输出："chopper is not a tanuki"</br>

提示：</br>
1 <= s.length <= 500</br>
k的取值范围是[1, s中单词的数目]</br>
s仅由大小写英文字母和空格组成</br>
s中的单词之间由单个空格隔开</br>
不存在前导或尾随空格</br>

[Link](https://leetcode-cn.com/problems/truncate-sentence/)