from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        tot = len(nums1) + len(nums2)
        if tot & 1 == 0:
            left = self.find(nums1, 0, nums2, 0, tot // 2)
            right = self.find(nums1, 0, nums2, 0, tot // 2 + 1)
            return (left + right) / 2
        else:
            return self.find(nums1, 0, nums2, 0, tot // 2 + 1)

    def find(self, n1, i, n2, j, k) -> int:
        if len(n1) - i > len(n2) - j:
            return self.find(n2, j, n1, i, k)
        if i >= len(n1):
            return n2[j + k - 1]
        if k == 1:
            return min(n1[i], n2[j])
        else:
            si = min(i + k // 2, len(n1))
            sj = j + k - k // 2
            if n1[si - 1] > n2[sj - 1]:
                return self.find(n1, i, n2, sj, k - (sj - j))
            else:
                return self.find(n1, si, n2, j, k - (si - i))
