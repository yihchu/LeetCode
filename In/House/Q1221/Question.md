<h1>分割平衡字符串</h1>

在一个平衡字符串中，'L'和'R'字符的数量是相同的。</br>
给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。</br>
注意：分割得到的每个字符串都必须是平衡字符串。</br>
返回可以通过分割得到的平衡字符串的最大数量。</br>

示例1：</br>
输入：s = "RLRRLLRLRL"</br>
输出：4</br>
解释：s可以分割为"RL"、"RRLL"、"RL"、"RL"，每个子字符串中都包含相同数量的'L'和'R'。</br>

示例2：</br>
输入：s = "RLLLLRRRLR"</br>
输出：3</br>
解释：s可以分割为"RL"、"LLLRRR"、"LR"，每个子字符串中都包含相同数量的'L'和'R'。</br>

示例3：</br>
输入：s = "LLLLRRRR"</br>
输出：1</br>
解释：s只能保持原样"LLLLRRRR".</br>

示例4：</br>
输入：s = "RLRRRLLRLL"</br>
输出：2</br>
解释：s可以分割为"RL"、"RRRLLRLL"，每个子字符串中都包含相同数量的'L'和'R'。</br>

提示：
- 1 <= s.length <= 1000
- s[i] = 'L' 或 'R'
- s是一个平衡字符串

[Link](https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/)