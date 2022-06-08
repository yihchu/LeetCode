package In.House.Q1037;

public class Solution {

    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isBoomerang(new int[][] {{1, 1}, {2, 3}, {3, 2}})); // true
        System.out.println(slt.isBoomerang(new int[][] {{1, 1}, {2, 2}, {3, 3}})); // false
        System.out.println(slt.isBoomerang(new int[][] {{0, 0}, {0, 2}, {2, 1}})); // true
    }

}
