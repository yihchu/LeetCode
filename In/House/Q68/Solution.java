package In.House.Q68;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = maxWidth, len = words.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; ) {
            String word = words[i];
            int l = (left == maxWidth ? word.length() : 1 + word.length());
            if (left >= l) {
                if (left != maxWidth) {
                    builder.append(" ");
                }
                builder.append(word);
                left -= l;
                ++i;
            } else {
                String[] array = builder.toString().split(" ");
                if (array.length == 1) {
                    result.add(array[0] + getSpaces(maxWidth - array[0].length()));
                } else {
                    String spaces = getSpaces(left / (array.length - 1) + 1);
                    left %= (array.length - 1);
                    StringBuilder b = new StringBuilder();
                    b.append(array[0]);
                    for (int j = 1; j < array.length; ++j) {
                        b.append(spaces);
                        if (left > 0) {
                            b.append(" ");
                            --left;
                        }
                        b.append(array[j]);
                    }
                    result.add(b.toString());
                }

                left = maxWidth;
                builder = new StringBuilder();
            }
        }
        String str = builder.toString();
        if (!str.equals("")) {
            result.add(str + getSpaces(maxWidth - str.length()));
        }
        return result;
    }

    private String getSpaces(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(">>>>>>>>>> test-1");
        slt.fullJustify(new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16).stream().forEach(str -> System.out.println("*" + str + "*"));
        System.out.println("<<<<<<<<<<");
        System.out.println();
        System.out.println(">>>>>>>>>> test-2");
        slt.fullJustify(new String[]{
                "What", "must", "be", "acknowledgment", "shall", "be"
        }, 16).stream().forEach(str -> System.out.println("*" + str + "*"));
        System.out.println("<<<<<<<<<<");
        System.out.println();
        System.out.println(">>>>>>>>>> test-3");
        slt.fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20).stream().forEach(str -> System.out.println("*" + str + "*"));
        System.out.println("<<<<<<<<<<");
    }

}


/**
Ques: 文本左右对齐
Link: https://leetcode-cn.com/problems/text-justification/

给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有maxWidth个字符。
要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:
单词是指由非空格字符组成的字符序列。
每个单词的长度大于0，小于等于maxWidth。
输入单词数组words至少包含一个单词。

示例1:
输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

示例2:
输入:
words = ["What", "must", "be", "acknowledgment", "shall", "be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为"shall be    "而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。
     第二行同样为左对齐，这是因为这行只包含一个单词。

示例3:
输入:
words = ["Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
         "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

*/