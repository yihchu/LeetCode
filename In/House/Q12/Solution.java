package In.House.Q12;

public class Solution {

    public String intToRoman(int num) {
        int[] steps = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4};
        String[] strs = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 12; i += 2) {
            while (num >= steps[i]) {
                result.append(strs[i]);
                num -= steps[i];
            }
            if (num >= steps[i + 1]) {
                result.append(strs[i + 1]);
                num -= steps[i + 1];
            }
        }
        while (num >= 1) {
            result.append("I");
            num -= 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.intToRoman(3)); // III
        System.out.println(slt.intToRoman(4)); // IV
        System.out.println(slt.intToRoman(9)); // IX
        System.out.println(slt.intToRoman(58)); // LVIII
        System.out.println(slt.intToRoman(1994)); // MCMXCIV
    }

}
