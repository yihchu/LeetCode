package In.House.Q541;

public class Solution {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int k2 = k * 2, idx = k2;
        for (; idx < len; idx += k2) {
            reverse(arr, idx - k2, idx - k - 1);
        }
        int left = idx - len;
        if (left <= k) {
            int pos = idx - k2;
            reverse(arr, pos, pos + k - 1);
        } else if (left < k2) {
            reverse(arr, idx - k2, len - 1);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            ++l;--r;
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.reverseStr("abcdefg", 2)); // bacdfeg
        System.out.println(slt.reverseStr("abcdef", 2)); // bacdfe
        System.out.println(slt.reverseStr("abcde", 2)); // bacde
        System.out.println(slt.reverseStr("abcd", 2)); // bacd
    }

}

/**
Link: https://leetcode-cn.com/problems/reverse-string-ii/

给定一个字符串s和一个整数k，从字符串开头算起，每2k个字符反转前k个字符。
如果剩余字符少于k个，则将剩余字符全部反转。
如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样。

示例1：
输入：s = "abcdefg", k = 2
输出："bacdfeg"

示例2：
输入：s = "abcd", k = 2
输出："bacd"

提示：
1 <= s.length <= 10^4
s仅由小写英文组成
1 <= k <= 10^4

*/