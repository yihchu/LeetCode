package In.House.Q1996;

import java.util.Arrays;

public class Solution {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (p1, p2) -> p1[0] == p2[0] ? (p1[1] - p2[1]) : (p2[0] - p1[0]));
        int max = 0, count = 0;
        for (int[] p: properties) {
            if (p[1] < max) {
                ++count;
            } else {
                max = p[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfWeakCharacters(new int[][] {{5, 5}, {6, 3}, {3, 6}})); // 0
        System.out.println(slt.numberOfWeakCharacters(new int[][] {{2, 2}, {3, 3}})); // 1
        System.out.println(slt.numberOfWeakCharacters(new int[][] {{1, 5}, {10, 4}, {4, 3}})); // 1
        System.out.println(slt.numberOfWeakCharacters(new int[][] {{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}})); // 6
    }

}
