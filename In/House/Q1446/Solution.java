package In.House.Q1446;

public class Solution {

    public int maxPower(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int count = 1, max = 0;
        char c = s.charAt(0);
        for (int i = 1; i < len; ++i) {
            char tmp = s.charAt(i);
            if (c == tmp) {
                ++count;
                continue;
            }
            max = max < count ? count : max;
            c = tmp;
            count = 1;
        }
        max = max < count ? count : max;
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxPower("leetcode")); // 2
        System.out.println(slt.maxPower("abbcccddddeeeeedcba")); // 5
        System.out.println(slt.maxPower("triplepillooooow")); // 5
        System.out.println(slt.maxPower("hooraaaaaaaaaaay")); // 11
        System.out.println(slt.maxPower("tourist")); // 1
        System.out.println(slt.maxPower("cc")); // 2
    }

}
