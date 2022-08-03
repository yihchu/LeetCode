package Sword.to.Offer.V2.Q69;

public class Solution {

    // O(n)
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int maxIdx = 1;
        for (int i = 2; i < len - 1; ++i) {
            maxIdx = arr[maxIdx] < arr[i] ? i : maxIdx;
        }
        return maxIdx;
    }

//    // O(n^2)
//    public int peakIndexInMountainArray(int[] arr) {
//
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.peakIndexInMountainArray(new int[] {0, 1, 0})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[] {1, 3, 5, 4, 2})); // 2
        System.out.println(slt.peakIndexInMountainArray(new int[] {0, 10, 5, 2})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[] {3, 4, 5, 1})); // 2
        System.out.println(slt.peakIndexInMountainArray(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19})); // 2
    }

}

