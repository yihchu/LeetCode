package In.House.Q917;

public class Solution {

//    // 遍历两遍
//    public String reverseOnlyLetters(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//        int len = chars.length;
//        for (int i = 0; i < len; ++i) {
//            char c = chars[i];
//            if (c >= 'a' && c <= 'z' || c >= 'A' && c <='Z') {
//                stack.add(c);
//                chars[i] = 1;
//            }
//        }
//        for (int i = 0; i < len; ++i) {
//            if (chars[i] == 1) {
//                chars[i] = stack.pop();
//            }
//        }
//        return new String(chars);
//    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (true) {
            while (l < r && !(chars[l] >= 'a' && chars[l] <= 'z' || chars[l] >= 'A' && chars[l] <= 'Z')) {
                ++l;
            }
            while (l < r && !(chars[r] >= 'a' && chars[r] <= 'z' || chars[r] >= 'A' && chars[r] <= 'Z')) {
                --r;
            }
            if (l >= r) {
                break;
            }
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            ++l;
            --r;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.reverseOnlyLetters("ab-cd")); // "dc-ba"
        System.out.println(slt.reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"
        System.out.println(slt.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // "Qedo1ct-eeLg=ntse-T!"
        System.out.println(slt.reverseOnlyLetters("-")); // "-"
    }

}
