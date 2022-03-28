package In.House.Q877;

public class Solution {

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] m = new int[len][len];
        for (int i = len - 1; i > -1; --i) {
            for (int j = i ; j < len; ++j) {
                m[i][j] = i == j ? piles[i] : Math.max(piles[i] - m[i + 1][j], piles[j] - m[i][j - 1]);
            }
        }
        return m[0][len - 1] > 0;
    }

//    public boolean stoneGame(int[] piles) {
//        return true
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.stoneGame(new int[]{5, 3, 4, 5})); // true
        System.out.println(slt.stoneGame(new int[]{8, 9, 7, 6, 7, 6})); // true
        System.out.println(slt.stoneGame(new int[]{6, 7, 6, 7, 9, 8})); // true
        System.out.println(slt.stoneGame(new int[]{6, 3, 9, 9, 3, 8, 8, 7})); // true
    }

}
