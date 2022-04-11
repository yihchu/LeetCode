package In.House.Q43;

public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2;
        int[] arr = new int[len];
        for (int i = len1 - 1; i > -1; --i) {
            for (int j = len2 - 1; j > -1; --j) {
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = len - 1; i > 0; --i) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int idx = arr[0] == 0 ? 1 : 0;
        StringBuilder builder = new StringBuilder();
        while (idx < len) {
            builder.append(arr[idx ++]);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.multiply("2", "3")); // "6"
        System.out.println(slt.multiply("123", "456")); // "56088"
    }

}


