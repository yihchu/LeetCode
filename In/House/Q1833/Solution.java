package In.House.Q1833;

import java.util.Arrays;

public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int len = costs.length, result = 0;
        for (int i = 0; i < len; ++i) {
            if (coins < costs[i]) {
                return result;
            }
            coins -= costs[i];
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7)); // 4
        System.out.println(slt.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5)); // 0
        System.out.println(slt.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20)); // 6
    }

}

