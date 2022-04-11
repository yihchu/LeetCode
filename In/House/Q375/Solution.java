package In.House.Q375;

public class Solution {

    /**
     * f(i, j) = min(∑(k = i, j) k + max(f(i, k - 1), f(k + 1, j)))
     *                        =>
     * f(1, n) = min(∑(k = 1, n) k + max(f(1, k - 1), f(k + 1, j)))
     */
    public int getMoneyAmount(int n) {
        int[][] array = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            array[i][i] = 0;
        }
        for (int i = n - 1; i > 0; --i) {
            for (int j = i + 1; j <= n; ++j) {
                array[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    int tmp = k + Math.max(array[i][k - 1], array[k + 1][j]);
                    array[i][j] = array[i][j] > tmp ? tmp : array[i][j];
                }
            }
        }
        return array[1][n];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.getMoneyAmount(10)); // 16
        System.out.println(slt.getMoneyAmount(1)); // 0
        System.out.println(slt.getMoneyAmount(2)); // 1
    }

}

