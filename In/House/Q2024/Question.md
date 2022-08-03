<h1>考试的最大困扰度</h1>

一位老师正在出一场由n道判断题构成的考试，每道题的答案为true（用'T'表示）或者false（用'F'表示）。老师想增加学生对自己做出答案的不确定性，方法是最大化有连续相同结果的题数。（也就是连续出现true或者连续出现false）。</br>
给你一个字符串answerKey，其中answerKey[i]是第i个问题的正确结果。除此以外，还给你一个整数k，表示你能进行以下操作的最多次数：</br>
每次操作中，将问题的正确答案改为'T'或者'F'（也就是将answerKey[i]改为'T'或者'F'）。</br>
请你返回在不超过k次操作的情况下，最大连续'T'或者'F'的数目。</br>

示例1：</br>
输入：answerKey = "TTFF", k = 2</br>
输出：4</br>
解释：我们可以将两个'F'都变为'T'，得到answerKey = "TTTT"。</br>
总共有四个连续的'T'。</br>

示例2：</br>
输入：answerKey = "TFFT", k = 1</br>
输出：3</br>
解释：我们可以将最前面的'T'换成'F'，得到answerKey = "FFFT"。</br>
或者，我们可以将第二个'T' 换成'F'，得到answerKey = "TFFF"。</br>
两种情况下，都有三个连续的'F'。</br>

示例3：</br>
输入：answerKey = "TTFTTFTT", k = 1</br>
输出：5</br>
解释：我们可以将第一个'F'换成'T'，得到answerKey = "TTTTTFTT"。</br>
或者我们可以将第二个'F'换成'T'，得到answerKey = "TTFTTTTT"。</br>
两种情况下，都有五个连续的'T'。</br>

提示：
- n == answerKey.length
- 1 <= n <= 5 * 10^4
- answerKey[i]要么是'T'，要么是'F'
- 1 <= k <= n

[Link](https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/)