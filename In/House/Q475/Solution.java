package In.House.Q475;

import java.util.Arrays;

public class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int hsIdx = 0, htIdx = 0;
        int left = -1, right = heaters[htIdx];
        int radius = 0;
        while (hsIdx < houses.length) {
            if (houses[hsIdx] <= right) {
                radius = Math.max(radius, left < 0
                        ? (right - houses[hsIdx])
                        : Math.min(houses[hsIdx] - left, right - houses[hsIdx]));
                ++hsIdx;
                continue;
            }
            ++htIdx;
            left = right;
            right = htIdx < heaters.length ? heaters[htIdx] : Integer.MAX_VALUE;
        }
        return radius;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.findRadius(new int[] {1, 2, 3}, new int[] {2})); // 1
//        System.out.println(slt.findRadius(new int[] {1, 2, 3, 4}, new int[] {1, 4})); // 1
//        System.out.println(slt.findRadius(new int[] {1, 5}, new int[] {2})); // 3
        System.out.println(slt.findRadius(
                new int[] {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[] {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612})); // 3
    }

}

