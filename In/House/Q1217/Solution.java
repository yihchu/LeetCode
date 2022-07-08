package In.House.Q1217;

public class Solution {

    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for (int pos: position) {
            if (pos % 2 == 0) {
                ++ even;
            } else {
                ++ odd;
            }
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minCostToMoveChips(new int[] {1, 2, 3})); // 1
        System.out.println(slt.minCostToMoveChips(new int[] {2, 2, 2, 3, 3})); // 2
    }

}
