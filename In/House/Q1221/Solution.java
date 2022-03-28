package In.House.Q1221;

public class Solution {

    public int balancedStringSplit(String s) {
        int len = s.length();
        int l = 0, r = 0, count = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'L') {
                ++l;
            } else {
                ++r;
            }
            if (l == r) {
                ++count;
                l = r = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(slt.balancedStringSplit("RLLLLRRRLR")); // 3
        System.out.println(slt.balancedStringSplit("LLLLRRRR")); // 1
        System.out.println(slt.balancedStringSplit("RLRRRLLRLL")); // 2
    }

}
