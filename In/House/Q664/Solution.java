package In.House.Q664;

import java.util.Arrays;

public class Solution {

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
        Solution slt = new Solution();
        System.out.println(slt.strangePrinter("aaabbb")); // 2
        System.out.println(slt.strangePrinter("aba")); // 2
    }
}




