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
