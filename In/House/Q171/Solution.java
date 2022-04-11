package In.House.Q171;

public class Solution {

    public int titleToNumber(String columnTitle) {
        int base = (int)'A' - 1, len = columnTitle.length();
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum *= 26;
            sum += (int)columnTitle.charAt(i) - base;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.titleToNumber("A"));
        System.out.println(slt.titleToNumber("AB"));
        System.out.println(slt.titleToNumber("ZY"));
    }

}


