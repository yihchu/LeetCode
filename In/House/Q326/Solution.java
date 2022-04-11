package In.House.Q326;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Set<Integer> sets = new HashSet<>() {{
        int start = 1;
        while (start > 0) {
            add(start);
            start *= 3;
        }
    }};

    public boolean isPowerOfThree(int n) {
        return sets.contains(n);
    }

//    // 官方答案，优秀
//    public boolean isPowerOfThree(int n) {
//        return n > 0 && 1162261467 % n == 0;
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isPowerOfThree(27));
        System.out.println(slt.isPowerOfThree(0));
        System.out.println(slt.isPowerOfThree(9));
        System.out.println(slt.isPowerOfThree(45));
    }

}