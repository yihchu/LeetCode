package In.House.Q1995;

public class Solution {

    public int countQuadruplets(int[] nums) {
        int len = nums.length, sum = 0;
        for (int a = 0; a < len - 3; ++a) {
            for (int b = a + 1; b < len - 2; ++b) {
                for (int c = b + 1; c < len - 1; ++c) {
                    for (int d = c + 1; d < len; ++d) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ++ sum;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countQuadruplets(new int[] {1, 2, 3, 6})); // 1
        System.out.println(slt.countQuadruplets(new int[] {3, 3, 6, 4, 5})); // 0
        System.out.println(slt.countQuadruplets(new int[] {1, 1, 1, 3, 5})); // 4
        System.out.println(slt.countQuadruplets(new int[] {28, 8, 49, 85, 37, 90, 20, 8})); // 1
    }

}
