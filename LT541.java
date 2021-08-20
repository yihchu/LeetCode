public class LT541 {

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
        LT541 lt541 = new LT541();
        System.out.println(lt541.reverseStr("abcdefg", 2)); // bacdfeg
        System.out.println(lt541.reverseStr("abcdef", 2)); // bacdfe
        System.out.println(lt541.reverseStr("abcde", 2)); // bacde
        System.out.println(lt541.reverseStr("abcd", 2)); // bacd
    }

}

/*

给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

示例 1：
输入：s = "abcdefg", k = 2
输出："bacdfeg"

示例 2：
输入：s = "abcd", k = 2
输出："bacd"

提示：
1 <= s.length <= 10^4
s 仅由小写英文组成
1 <= k <= 10^4

*/