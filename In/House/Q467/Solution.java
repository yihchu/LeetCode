package In.House.Q467;

import java.util.Arrays;

public class Solution {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        int count = 1, len = p.length();
        dp[chars[0] - 'a'] = 1;
        for (int i = 1; i < len; ++i) {
            if (chars[i] -  chars[i - 1] == 1 || chars[i - 1] -  chars[i] == 25) {
                ++count;
            } else {
                count = 1;
            }
            dp[chars[i] - 'a'] = Math.max(dp[p.charAt(i) - 'a'], count);
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findSubstringInWraproundString("a")); // 1
        System.out.println(slt.findSubstringInWraproundString("cac")); // 2
        System.out.println(slt.findSubstringInWraproundString("zab")); // 6
    }

}
