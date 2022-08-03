package Sword.to.Offer.V1.Q53;

import java.util.Arrays;

public class Solution {

    public int search(int[] nums, int target) {
        return (int)Arrays.stream(nums).filter(n -> n == target).count();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.search(new int[]{5, 7, 7, 8, 8, 10}, 8)); // 2
        System.out.println(slt.search(new int[]{5, 7, 7, 8, 8, 10}, 6)); // 0
    }

}
