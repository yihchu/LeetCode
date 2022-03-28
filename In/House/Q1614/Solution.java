package In.House.Q1614;

public class Solution {

    public int maxDepth(String s) {
        int count = 0, max = Integer.MIN_VALUE, len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                ++count;
            } else if (s.charAt(i) == ')') {
                --count;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxDepth("(1+(2*3)+((8)/4))+1")); // 3
        System.out.println(slt.maxDepth("(1)+((2))+(((3)))")); // 3
        System.out.println(slt.maxDepth("1+(2*3)/(2-1)")); // 1
        System.out.println(slt.maxDepth("1")); // 0
    }

}
