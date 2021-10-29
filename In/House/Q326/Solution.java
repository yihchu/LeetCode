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

/**
Link: https://leetcode-cn.com/problems/power-of-three/

给定一个整数，写一个函数来判断它是否是3的幂次方。如果是，返回true；否则，返回false。
整数n是3的幂次方需满足：存在整数x使得n == 3^x

示例1：
输入：n = 27
输出：true

示例2：
输入：n = 0
输出：false

示例3：
输入：n = 9
输出：true

示例4：
输入：n = 45
输出：false

提示：
-2^31 <= n <= 2^31 - 1

进阶：
你能不使用循环或者递归来完成本题吗？

*/