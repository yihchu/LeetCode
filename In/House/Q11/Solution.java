package In.House.Q11;

public class Solution {

    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        while (r > l) {
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(slt.maxArea(new int[] {1, 1})); // 1
        System.out.println(slt.maxArea(new int[] {4, 3, 2, 1, 4})); // 16
        System.out.println(slt.maxArea(new int[] {1, 2, 1})); // 2
    }

}
