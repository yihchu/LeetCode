package Interview.N01.Q05;

public class Solution {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        boolean flag = false;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (first.charAt(i) == second.charAt(j)) {
                ++i; ++j;
                continue;
            }
            if (flag) {
                return false;
            }
            flag = true;
            if (len1 > len2) {
                ++i;
            } else if (len1 < len2) {
                ++j;
            } else {
                ++i;
                ++j;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.oneEditAway("pale", "ple")); // true
        System.out.println(slt.oneEditAway("pales", "pal")); // false
    }

}
