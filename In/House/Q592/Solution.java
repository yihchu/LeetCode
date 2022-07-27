package In.House.Q592;

public class Solution {

    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1;
        int idx = 0, len = expression.length();
        while (idx < len) {
            long denominator1 = 0, sign = 1;
            if (expression.charAt(idx) == '-' || expression.charAt(idx) == '+') {
                sign = expression.charAt(idx) == '-' ? -1 : 1;
                ++ idx;
            }
            while (idx < len && Character.isDigit(expression.charAt(idx))) {
                denominator1 = denominator1 * 10 + (expression.charAt(idx) - '0');
                ++ idx;
            }
            denominator1 = sign * denominator1;
            ++ idx;
            long numerator1 = 0;
            while (idx < len && Character.isDigit(expression.charAt(idx))) {
                numerator1 = numerator1 * 10 + (expression.charAt(idx) - '0');
                ++ idx;
            }
            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long a = Math.abs(denominator), b = numerator;
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        long gcd = b;
        return denominator / gcd + "/" + numerator / gcd;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.fractionAddition("-1/2+1/2")); // "0/1"
        System.out.println(slt.fractionAddition("-1/2+1/2+1/3")); // "1/3"
        System.out.println(slt.fractionAddition("1/3-1/2")); // "-1/6"
    }

}
