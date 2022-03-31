package In.House.Q537;

public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split("\\+");
        String[] arr2 = num2.split("\\+");
        int a = Integer.valueOf(arr1[0]) * Integer.valueOf(arr2[0]) - Integer.valueOf(rmvI(arr1[1])) * Integer.valueOf(rmvI(arr2[1]));
        int b = Integer.valueOf(arr1[0]) * Integer.valueOf(rmvI(arr2[1])) + Integer.valueOf(rmvI(arr1[1])) * Integer.valueOf(arr2[0]);
        return a + "+" + b + "i";
    }

    private String rmvI(String str) {
        return str.substring(0, str.length() - 1);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.complexNumberMultiply("1+1i", "1+1i")); // "0+2i"
        System.out.println(slt.complexNumberMultiply("1+-1i", "1+-1i")); // "0+-2i"
    }

}


