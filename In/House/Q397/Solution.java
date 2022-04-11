package In.House.Q397;

public class Solution {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return integerReplacement(n - 1);
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        for (int i = 1; i < 20; ++i) {
            System.out.println(">>>>> i = " + i + " => " + slt.integerReplacement(i));
        }
        System.out.println(">>>>> 2147483647 = 2147483647 => " + slt.integerReplacement(2147483647));
    }

}

