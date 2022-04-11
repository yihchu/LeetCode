<h1>Z字形变换</h1>

将一个给定字符串s根据给定的行数numRows，以从上往下、从左到右进行Z字形排列。</br>
比如输入字符串为"PAYPALISHIRING"行数为3时，排列如下：</br>

    P   A   H   N
    A P L S I I G
    Y   I   R

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。</br>
请你实现这个将字符串进行指定行数变换的函数：</br>
string convert(string s, int numRows);</br>

示例1：</br>
输入：s = "PAYPALISHIRING", numRows = 3</br>
输出："PAHNAPLSIIGYIR"</br>

示例2：</br>
输入：s = "PAYPALISHIRING", numRows = 4</br>
输出："PINALSIGYAHRPI"</br>
解释：</br>

    P     I    N
    A   L S  I G
    Y A   H R
    P     I

示例3：</br>
输入：s = "A", numRows = 1</br>
输出："A"</br>

提示：</br>
1 <= s.length <= 1000</br>
s 由英文字母（小写和大写）、',' 和 '.' 组成</br>
1 <= numRows <= 1000</br>

[Link](https://leetcode-cn.com/problems/zigzag-conversion/)