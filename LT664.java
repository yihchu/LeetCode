import java.util.Arrays;

public class LT664 {

    // second
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] res = new int[len][len];
        for (int i = len - 1; i > -1; --i) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
            for (int j = i; j < len; ++j) {
                if (i == j) {
                    res[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    res[i][j] = res[i][j - 1];
                }
                for (int k = i; k < j; ++k) {
                    int tmp = res[i][k] + res[k + 1][j];
                    res[i][j] = res[i][j] > tmp ? tmp : res[i][j];
                }
            }
        }
        return res[0][len - 1];
    }

    // first
//    public int strangePrinter(String s) {
//        int len = s.length();
//        int[][] m = new int[len][len];
//        for (int i = len - 1; i > -1; --i) {
//            for (int j = i; j < len; ++j) {
//                m[i][j] = j - i + 1;
//                if (j > i && s.charAt(i) == s.charAt(j)) {
//                    m[i][j] = m[i][j - 1];
//                    continue;
//                }
//                for (int k = i; k < j; ++k) {
//                    int tmp = m[i][k] + m[k + 1][j];
//                    m[i][j] = m[i][j] < tmp ? m[i][j] : tmp;
//                }
//            }
//        }
//        return m[0][len - 1];
//    }

    public static void main(String[] args) {
        LT664 lt664 = new LT664();
        System.out.println(lt664.strangePrinter("aaabbb")); // 2
        System.out.println(lt664.strangePrinter("aba")); // 2
    }
}


/*
有台奇怪的打印机有以下两个特殊要求：

打印机每次只能打印由 同一个字符 组成的序列。
每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。

示例 1：
f (i, j) = f(i, j - 1) s[i] == s[len]
           = min(f(i, k) + f(k + 1, j))


return f(0, len - 1)
输入：s = "aaabbb"
输出：2
解释：首先打印 "aaa" 然后打印 "bbb"。
示例 2：

输入：s = "aba"
输出：2
解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。

提示：

1 <= s.length <= 100
s 由小写英文字母组成
*/

