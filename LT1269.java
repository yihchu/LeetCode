public class LT1269 {

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
        LT1269 lt1269 = new LT1269();
        System.out.println(lt1269.numWays(3, 2)); // 4
        System.out.println(lt1269.numWays(2, 4)); // 2
        System.out.println(lt1269.numWays(4, 2)); // 8
        System.out.println(lt1269.numWays(27, 7));
    }

}

/*
对于计算方案数的题目，常用的方法是动态规划。对于这道题，需要计算在 \textit{steps}steps 步操作之后，指针位于下标 00 的方案数。

用 \textit{dp}[i][j]dp[i][j] 表示在 ii 步操作之后，指针位于下标 jj 的方案数。其中，ii 的取值范围是 0 \le i \le \textit{steps}0≤i≤steps，jj 的取值范围是 0 \le j \le \textit{arrLen}-10≤j≤arrLen−1。

由于一共执行 \textit{steps}steps 步操作，因此指针所在下标一定不会超过 \textit{steps}steps，可以将 jj 的取值范围进一步缩小到 0 \le j \le \min(\textit{arrLen}-1, \textit{steps})0≤j≤min(arrLen−1,steps)。

当没有进行任何操作时，指针一定位于下标 00，因此动态规划的边界条件是 \textit{dp}[0][0]=1dp[0][0]=1，当 1 \le j \le \min(\textit{arrLen}-1, \textit{steps})1≤j≤min(arrLen−1,steps) 时有 \textit{dp}[0][j]=0dp[0][j]=0。

每一步操作中，指针可以向左或向右移动 11 步，或者停在原地。因此，当 1 \le i \le \textit{steps}1≤i≤steps 时，状态 \textit{dp}[i][j]dp[i][j] 可以从 \textit{dp}[i-1][j-1]dp[i−1][j−1]、\textit{dp}[i-1][j]dp[i−1][j] 和 \textit{dp}[i-1][j+1]dp[i−1][j+1] 这三个状态转移得到。状态转移方程如下：

\textit{dp}[i][j] = \textit{dp}[i-1][j-1]+\textit{dp}[i-1][j]+\textit{dp}[i-1][j+1]
dp[i][j]=dp[i−1][j−1]+dp[i−1][j]+dp[i−1][j+1]

由于指针不能移动到数组范围外，因此对于上述状态转移方程，需要注意下标边界情况。当 j=0j=0 时，\textit{dp}[i-1][j-1]=0dp[i−1][j−1]=0；当 j=\min(\textit{arrLen}-1, \textit{steps})j=min(arrLen−1,steps) 时，\textit{dp}[i-1][j+1]=0dp[i−1][j+1]=0。具体实现时，需要对下标进行判断，避免下标越界。

计算过程中需要对每个状态的值计算模 10^9+710
9
 +7 后的结果。最终得到 \textit{dp}[\textit{steps}][0]dp[steps][0] 的值即为答案。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/ting-zai-yuan-di-de-fang-an-shu-by-leetcode-soluti/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*
有一个长度为arrLen的数组，开始有一个指针在索引0处。

每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。

给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。

由于答案可能会很大，请返回方案数 模10^9 + 7 后的结果。

示例 1：

输入：steps = 3, arrLen = 2
输出：4
解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
向右，向左，不动
不动，向右，向左
向右，不动，向左
不动，不动，不动
示例 2：

输入：steps = 2, arrLen = 4
输出：2
解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
向右，向左
不动，不动
示例 3：

输入：steps = 4, arrLen = 2
输出：8
0 1
提示：

1 <= steps <= 500
1 <= arrLen<= 10^6
 */