package In.House.Q1269;

public class Solution {

    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        int col = Math.min(steps, arrLen);
        int[][] m = new int[steps][col];
        for (int i = 0; i < col; ++i) {
            m[0][i] = i < 2 ? 1 : 0;
        }
        for (int i = 1; i < steps; ++i) {
            for (int j = 0; j < col; ++j) {
                m[i][j] = m[i - 1][j];
                if (j - 1 > -1) {
                    m[i][j] = (m[i][j] + m[i - 1][j - 1]) % mod;
                }
                if (j + 1 < col) {
                    m[i][j] = (m[i][j] + m[i - 1][j + 1]) % mod;
                }
            }
        }
        return m[steps - 1][0] % mod;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numWays(3, 2)); // 4
        System.out.println(slt.numWays(2, 4)); // 2
        System.out.println(slt.numWays(4, 2)); // 8
        System.out.println(slt.numWays(27, 7));
    }

}

/*
思路：

对于计算方案数的题目，常用的方法是动态规划。对于这道题，需要计算在steps步操作之后，指针位于下标0的方案数。
用dp[i][j]表示在i步操作之后，指针位于下标j的方案数。其中，i的取值范围是0 ≤ i ≤ steps，j的取值范围是0≤ j ≤ arrLen − 1。
由于一共执行steps步操作，因此指针所在下标一定不会超过steps，可以将j的取值范围进一步缩小到0≤ j ≤ min(arrLen − 1,steps)。
当没有进行任何操作时，指针一定位于下标0，因此动态规划的边界条件是dp[0][0] = 1，当1 ≤ j ≤ min(arrLen − 1,steps)时有dp[0][j] = 0。
每一步操作中，指针可以向左或向右移动1步，或者停在原地。因此，当1≤ i ≤steps时，状态dp[i][j]可以从dp[i − 1][j − 1]、dp[i − 1][j]和dp[i − 1][j + 1]这三个状态转移得到。状态转移方程如下：

dp[i][j] = dp[i − 1][j − 1] + dp[i − 1][j] + dp[i − 1][j + 1]

由于指针不能移动到数组范围外，因此对于上述状态转移方程，需要注意下标边界情况。当j = 0时，dp[i−1][j−1] = 0；当j = min(arrLen − 1,steps)时，dp[i − 1][j + 1] = 0。具体实现时，需要对下标进行判断，避免下标越界。
计算过程中需要对每个状态的值计算模10^9 + 7后的结果。最终得到dp[steps][0]的值即为答案。
*/

/**
Ques: 停在原地的方案数
Link: https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/submissions/

有一个长度为arrLen的数组，开始有一个指针在索引0处。
每一步操作中，你可以将指针向左或向右移动1步，或者停在原地（指针不能被移动到数组范围外）。
给你两个整数steps和arrLen，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0处的方案数。
由于答案可能会很大，请返回方案数模10^9 + 7后的结果。

示例1：
输入：steps = 3, arrLen = 2
输出：4
解释：3步后，总共有4种不同的方法可以停在索引0处。
向右，向左，不动
不动，向右，向左
向右，不动，向左
不动，不动，不动

示例2：
输入：steps = 2, arrLen = 4
输出：2
解释：2步后，总共有2种不同的方法可以停在索引0处。
向右，向左
不动，不动

示例3：
输入：steps = 4, arrLen = 2
输出：8

提示：
1 <= steps <= 500
1 <= arrLen<= 10^6
 */