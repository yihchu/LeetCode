package In.House.Q2029;

public class Solution {

    public boolean stoneGameIX(int[] stones) {
        int[] counts = new int[3];
        for (int stone: stones) {
            ++ counts[stone % 3];
        }
        if (counts[0] % 2 == 0) {
            return counts[1] >= 1 && counts[2] >= 1;
        }
        return Math.abs(counts[1] - counts[2]) > 2;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.stoneGameIX(new int[] {2, 1})); // true
        System.out.println(slt.stoneGameIX(new int[] {2})); // false
        System.out.println(slt.stoneGameIX(new int[] {5, 1, 2, 4, 3})); // false
        System.out.println(slt.stoneGameIX(new int[] {2, 3})); // false
        System.out.println(slt.stoneGameIX(new int[] {15, 20, 10, 13, 14, 15, 5, 2, 3})); // false
    }

}