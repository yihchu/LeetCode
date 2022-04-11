package In.House.Q273;

public class Solution {

    private String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder builder = new StringBuilder();
        String numStr = "" + num;
        int len = numStr.length();
        int gap = (len - 1) / 3, pos = 0;
        for (int i = gap; i >= 0; --i) {
            String tmp = strToWords(numStr.substring(pos, len - 3 * i));
            builder.append(tmp);
            if (!tmp.equals("")) {
                builder.append(" ");
                builder.append(thousands[i]);
                builder.append(" ");
            }
            pos = len - 3 * i;
        }
        return builder.toString().trim();
    }

    private String strToWords(String str) {
        StringBuilder builder = new StringBuilder();
        int l = str.length();
        if (l == 1) {
            builder.append(singles[str.charAt(0) - '0']);
            return builder.toString();
        }
        if (l == 2) {
            char c = str.charAt(0);
            if (c == '0') {
                return strToWords("" + str.charAt(1));
            } else if (c == '1') {
                return teens[str.charAt(1) - '0'];
            } else {
                builder.append(tens[c - '0']);
                builder.append(" ");
                builder.append("" + singles[str.charAt(1) - '0']);
            }
            return builder.toString().trim();
        }
        // l == 3
        char c = str.charAt(0);
        if (c == '0') {
            return strToWords(str.substring(1));
        }
        builder.append(singles[c - '0']);
        builder.append(" Hundred ");
        builder.append(strToWords(str.substring(1)));
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println("*" + slt.numberToWords(0) + "*"); // "Zero"
        System.out.println("*" + slt.numberToWords(123) + "*"); // "One Hundred Twenty Three"
        System.out.println("*" + slt.numberToWords(12345) + "*"); // "Twelve Thousand Three Hundred Forty Five"
        // "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        System.out.println("*" + slt.numberToWords(1234567) + "*");
        // "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
        System.out.println("*" + slt.numberToWords(1234567891) + "*");
        // "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven"
        System.out.println("*" + slt.numberToWords(2147483647) + "*");
        System.out.println("*" + slt.numberToWords(1000000) + "*"); // "One Million"
        System.out.println("*" + slt.numberToWords(1000010) + "*"); // "One Million Ten"
    }

}
