package In.House.Q6;

public class Solution {

    public String convert(String s, int numRows) {
        int len = s.length(), maxGap = Math.max((numRows - 1) * 2, 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            int tmp = numRows - i - 1;
            int gap1 = (tmp - 1) * 2 + 1 + 1, gap2 = maxGap - gap1;
            gap1 = (gap1 == 0 ? gap2 : gap1);
            gap2 = (gap2 == 0 ? gap1 : gap2);
            boolean flag = true;
            for (int j = i; j < len; ) {
                builder.append(s.charAt(j));
                j += (flag ? gap1 : gap2);
                flag = !flag;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(slt.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(slt.convert("A", 1)); // A
    }

}

/**
Ques: Z字形变换
Link: https://leetcode-cn.com/problems/zigzag-conversion/

将一个给定字符串s根据给定的行数numRows，以从上往下、从左到右进行Z字形排列。
比如输入字符串为"PAYPALISHIRING"行数为3时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

示例1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"

示例2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I

示例3：
输入：s = "A", numRows = 1
输出："A"

提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000

*/