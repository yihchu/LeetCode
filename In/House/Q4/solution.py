from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1 = len(nums1)
        len2 = len(nums2)
        return (self.findKth(nums1, nums2, (len1 + len2 + 1) // 2) + self.findKth(nums1, nums2, (len1 + len2 + 2) // 2)) / 2

    def findKth(self, nums1: List[int], nums2: List[int], k: int) -> int:
        if nums1 is None or len(nums1) == 0:
            return nums2[k - 1]
        if nums2 is None or len(nums2) == 0:
            return nums1[k - 1]
        return self.doFindKth(nums1, 0, len(nums1) - 1, nums2, 0, len(nums2) - 1, k)

    def doFindKth(self, nums1: List[int], l1: int, r1: int, nums2: List[int], l2: int, r2: int, k: int):
        if l1 > r1:
            return nums2[l2 + k - 1]
        if l2 > r2:
            return nums1[l1 + k - 1]
        if k <= 1:
            return min(nums1[l1], nums2[l2])
        mid1 = l1 + k // 2 - 1
        mid1 = mid1 if mid1 <= r1 else r1
        mid2 = l2 + k // 2 - 1
        mid2 = mid2 if mid2 <= r2 else r2
        if nums1[mid1] < nums2[mid2]:
            return self.doFindKth(nums1, mid1 + 1, r1, nums2, l2, r2, k - (mid1 - l1 + 1))
        else:
            return self.doFindKth(nums1, l1, r1, nums2, mid2 + 1, r2, k - (mid2 - l2 + 1))

slt = Solution()
print(slt.findMedianSortedArrays([1, 3], [2]))
print(slt.findMedianSortedArrays([1, 2], [3, 4]))
print(slt.findMedianSortedArrays([0, 0], [0, 0]))
print(slt.findMedianSortedArrays([], [1]))
print(slt.findMedianSortedArrays([2], []))
print(slt.findMedianSortedArrays([19, 24, 31, 40, 47, 55, 66], [4, 19, 31, 43, 49, 58, 63, 63, 64, 76, 82, 86, 94, 97, 98]))

