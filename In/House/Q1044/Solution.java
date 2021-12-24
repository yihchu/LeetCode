package In.House.Q1044;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution {

    /**
     *  使用二分法找到那个L
     *  通过给s编码，来提高比对的速度
     *
     *  二分法很容易理解，但是这个编码，确实抄了一遍也没太明白
     */
    public String longestDupSubstring(String s) {
        Random random = new Random();
        int a1 = random.nextInt(75) + 26;
        int a2 = random.nextInt(75) + 26;
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = s.charAt(i) - 'a';
        }
        int l = 1, r = n - 1;
        int len = 0, start = -1;
        while (l <= r) {
            int m = l + (r - l + 1) / 2;
            int idx = check(arr, m, a1, a2, mod1, mod2);
            if (idx != -1) {
                l = m + 1;
                len = m;
                start = idx;
            } else {
                r = m - 1;
            }
        }
        return start != -1 ? s.substring(start, start + len) : "";
    }

    public int check(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        int n = arr.length;
        long aL1 = pow(a1, m, mod1);
        long aL2 = pow(a2, m, mod2);
        long h1 = 0, h2 = 0;
        for (int i = 0; i < m; ++i) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1;
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        Set<Long> seen = new HashSet<>();
        seen.add(h1 * mod2 + h2);
        for (int start = 1; start <= n - m; ++start) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1;
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
            long num = h1 * mod2 + h2;
            if (!seen.add(num)) {
                return start;
            }
        }
        return -1;
    }

    public long pow(int a, int m, int mod) {
        long ans = 1;
        long contribute = a;
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * contribute % mod;
                if (ans < 0) {
                    ans += mod;
                }
            }
            contribute = contribute * contribute % mod;
            if (contribute < 0) {
                contribute += mod;
            }
            m /= 2;
        }
        return ans;
    }

//    // 超时
//    public String longestDupSubstring(String s) {
//        int size = s.length();
//        int idx = -1, len = Integer.MIN_VALUE;
//        for (int i = 0; i < size; ++i) {
//            for (int j = i + 1; j < size; ++j) {
//                if (s.charAt(i) != s.charAt(j)) {
//                    continue;
//                }
//                int k = 1;
//                while (j + k < size && s.charAt(i + k) == s.charAt(j + k)) {
//                    ++k;
//                }
//                if (k > len) {
//                    len = k;
//                    idx = i;
//                }
//                if (k == size - 1) {
//                    i = size;
//                    break;
//                }
//            }
//        }
//        return idx < 0 ? "" : s.substring(idx, idx + len) ;
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestDupSubstring("banana")); // "ana"
        System.out.println(slt.longestDupSubstring("abcd")); // ""
        System.out.println(slt.longestDupSubstring("aa")); // "a"
        System.out.println(slt.longestDupSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // "a"
    }

}

/**
Link: https://leetcode-cn.com/problems/longest-duplicate-substring/

给你一个字符串s，考虑其所有重复子串：即，s的连续子串，在s中出现2次或更多次。这些出现之间可能存在重叠。
返回任意一个可能具有最长长度的重复子串。如果s不含重复子串，那么答案为""。

示例1：
输入：s = "banana"
输出："ana"

示例2：
输入：s = "abcd"
输出：""

提示：
2 <= s.length <= 3 * 10^4
s由小写英文字母组成
*/