<h1>文本左右对齐</h1>

给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。</br>
你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有maxWidth个字符。</br>
要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。</br>
文本的最后一行应为左对齐，且单词之间不插入额外的空格。</br>

说明:</br>
单词是指由非空格字符组成的字符序列。</br>
每个单词的长度大于0，小于等于maxWidth。</br>
输入单词数组words至少包含一个单词。</br>

示例1:</br>
输入:</br>
words = ["This", "is", "an", "example", "of", "text", "justification."]</br>
maxWidth = 16</br>
输出:</br>

    [
      "This    is    an",
      "example  of text",
      "justification.  "
    ]

示例2:</br>
输入:</br>
words = ["What", "must", "be", "acknowledgment", "shall", "be"]</br>
maxWidth = 16</br>
输出:</br>

    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]

解释: 注意最后一行的格式应为"shall be    "而不是 "shall     be",</br>
因为最后一行应为左对齐，而不是左右两端对齐。</br>
第二行同样为左对齐，这是因为这行只包含一个单词。</br>
</br>
示例3:</br>
输入:</br>
words = ["Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",</br>
"to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"]</br>
maxWidth = 20</br>
输出:</br>

    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]

[Link](https://leetcode-cn.com/problems/text-justification/)