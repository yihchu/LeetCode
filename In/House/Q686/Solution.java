package In.House.Q686;


public class Solution {

    // 还是简单粗暴的管用
    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int len = 2 * a.length() + b.length();
        int l = 0;
        while (l < len) {
            l += a.length();
            builder.append(a);
            if (l >= b.length() && builder.toString().contains(b)) {
                return l / a.length();
            }
        }
        return -1;
    }

//    // 超时
//    public int repeatedStringMatch(String a, String b) {
//        if (a.contains(b)) {
//            return 1;
//        }
//        int len = a.length(), llen = b.length();
//        List<Integer> ks = new ArrayList<>();
//        for (int k = 0; k < len; ++k) {
//            int i = k, j = 0;
//            boolean flag = false;
//            while (i < len && j < len) {
//                if (a.charAt(i ++) == b.charAt(j ++)) {
//                    flag = true;
//                    continue;
//                }
//                flag = false;
//                break;
//            }
//            if (i == len && flag) {
//                ks.add(k);
//            }
//        }
//        if (ks.size() == 0) {
//            return -1;
//        }
//        for (int k: ks) {
//            int result = 1;
//            String str = a.substring(k);
//            while (str.length() < llen) {
//                str += a;
//                ++result;
//            }
//            if (str.contains(b)) {
//                return result;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println(slt.repeatedStringMatch("a", "aa")); // 2
        System.out.println(slt.repeatedStringMatch("a", "a")); // 1
        System.out.println(slt.repeatedStringMatch("abc", "wxyz")); // -1
        System.out.println(slt.repeatedStringMatch("aa", "a")); // 1
        System.out.println(slt.repeatedStringMatch("abc", "cabcabca")); // 4
        System.out.println(slt.repeatedStringMatch("abaabaa", "abaababaab")); // -1
    }

}
