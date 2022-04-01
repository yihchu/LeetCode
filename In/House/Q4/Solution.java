package In.House.Q4;


import java.util.Objects;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        return (findKth(nums1, nums2, (len1 + len2 + 1) / 2) + findKth(nums1, nums2, (len1 + len2 + 2) / 2)) / 2.0;
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        if (Objects.isNull(nums1) || nums1.length == 0) {
            return nums2[k - 1];
        }
        if (Objects.isNull(nums2) || nums2.length == 0) {
            return nums1[k - 1];
        }
        return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
    }

    private int findKth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        if (l1 > r1) {
            return nums2[l2 + k - 1];
        }
        if (l2 > r2) {
            return nums1[l1 + k - 1];
        }
        if (k <= 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        int mid1 = l1 + k / 2 - 1;
        mid1 = mid1 <= r1 ? mid1 : r1;
        int mid2 = l2 + k / 2 - 1;
        mid2 = mid2 <= r2 ? mid2 : r2;
        if (nums1[mid1] < nums2[mid2]) {
            return findKth(nums1, mid1 + 1, r1, nums2, l2, r2, k - (mid1 - l1 + 1));
        } else {
            return findKth(nums1, l1, r1, nums2, mid2 + 1, r2, k - (mid2 - l2 + 1));
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findMedianSortedArrays(new int[] {1, 3}, new int[] {2})); // 2.00000
        System.out.println(slt.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4})); // 2.50000
        System.out.println(slt.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0})); // 0.00000
        System.out.println(slt.findMedianSortedArrays(new int[] {}, new int[] {1})); // 1.00000
        System.out.println(slt.findMedianSortedArrays(new int[] {2}, new int[] {})); // 2.00000
        System.out.println(slt.findMedianSortedArrays(new int[] {19, 24, 31, 40, 47, 55, 66},  // 56.5
                new int[] {4, 19, 31, 43, 49, 58, 63, 63, 64, 76, 82, 86, 94, 97, 98}));
    }

}


