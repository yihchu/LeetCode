package In.House.Q8;

public class Solution {

    public int myAtoi(String s) {
        long result = 0;
        boolean nFlag = false;
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char firstChar = s.charAt(0);
        if (firstChar == '-' || firstChar == '+') {
            s = s.substring(1);
            nFlag = firstChar == '-' ? true : false;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            builder.append(currentChar);
        }
        if (builder.length() == 0) {
            return 0;
        }
        try {
            result = Long.parseLong(builder.toString());
            result = nFlag ? -result : result;
            result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
            result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result;
        } catch (Exception e) {
            return nFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {

        Solution slt = new Solution();

        String str1 = "-91283472332";
        String str2 = "words and 987";
        String str3 = "4193 with words";
        String str4 = "   -42";
        String str5 = "42";
        String str6 = "20000000000000000000";
        System.out.println(">>>>> " + str1 + " -> " + slt.myAtoi(str1));
        System.out.println(">>>>> " + str2 + " -> " + slt.myAtoi(str2));
        System.out.println(">>>>> " + str3 + " -> " + slt.myAtoi(str3));
        System.out.println(">>>>> " + str4 + " -> " + slt.myAtoi(str4));
        System.out.println(">>>>> " + str5 + " -> " + slt.myAtoi(str5));
        System.out.println(">>>>> " + str6 + " -> " + slt.myAtoi(str6));
    }
}
