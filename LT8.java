

public class LT8 {

    public int myAtoi(String str) {
        long result = 0;
        boolean nFlag = false;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char firstChar = str.charAt(0);
        if (firstChar == '-' || firstChar == '+') {
            str = str.substring(1);
            nFlag = firstChar == '-' ? true : false;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char currentChar = str.charAt(i);
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
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

        Main m = new Main();

        String str1 = "-91283472332";
        String str2 = "words and 987";
        String str3 = "4193 with words";
        String str4 = "   -42";
        String str5 = "42";
        String str6 = "20000000000000000000";
        System.out.println(">>>>> " + str1 + " -> " + m.myAtoi(str1));
        System.out.println(">>>>> " + str2 + " -> " + m.myAtoi(str2));
        System.out.println(">>>>> " + str3 + " -> " + m.myAtoi(str3));
        System.out.println(">>>>> " + str4 + " -> " + m.myAtoi(str4));
        System.out.println(">>>>> " + str5 + " -> " + m.myAtoi(str5));
        System.out.println(">>>>> " + str6 + " -> " + m.myAtoi(str6));
    }
}
