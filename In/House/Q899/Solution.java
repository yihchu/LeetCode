package In.House.Q899;

import java.util.Arrays;

public class Solution {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String result = s;
            StringBuilder builder = new StringBuilder(s);
            int len = s.length();
            for (int i = 1; i < len; ++i) {
                char c = builder.charAt(0);
                builder.deleteCharAt(0);
                builder.append(c);
                if (builder.toString().compareTo(result) < 0) {
                    result = builder.toString();
                }
            }
            return result;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.orderlyQueue("cba", 1)); // "acb"
        System.out.println(slt.orderlyQueue("baaca", 3)); // "aaabc"
    }

}
