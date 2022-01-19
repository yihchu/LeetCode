package In.House.Q1816;


public class Solution {

    public String truncateSentence(String s, int k) {
        String[] array = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; ++i) {
            builder.append(array[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.truncateSentence("Hello how are you Contestant", 4)); // Hello how are you
        System.out.println(slt.truncateSentence("What is the solution to this problem", 4)); // What is the solution
        System.out.println(slt.truncateSentence("chopper is not a tanuki", 5)); // chopper is not a tanuki
    }

}

/**
Ques: 截断句子
Link: https://leetcode-cn.com/problems/truncate-sentence/

句子是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
例如，"Hello World"、"HELLO"和"hello world hello world"都是句子。
给你一个句子s和一个整数k，请你将s截断，使截断后的句子仅含前k个单词。返回截断s后得到的句子。

示例1：
输入：s = "Hello how are you Contestant", k = 4
输出："Hello how are you"
解释：
s中的单词为["Hello", "how" "are", "you", "Contestant"]
前4个单词为["Hello", "how", "are", "you"]
因此，应当返回"Hello how are you"

示例2：
输入：s = "What is the solution to this problem", k = 4
输出："What is the solution"
解释：
s中的单词为["What", "is" "the", "solution", "to", "this", "problem"]
前4个单词为["What", "is", "the", "solution"]
因此，应当返回"What is the solution"

示例3：
输入：s = "chopper is not a tanuki", k = 5
输出："chopper is not a tanuki"

提示：
1 <= s.length <= 500
k的取值范围是[1, s中单词的数目]
s仅由大小写英文字母和空格组成
s中的单词之间由单个空格隔开
不存在前导或尾随空格

*/