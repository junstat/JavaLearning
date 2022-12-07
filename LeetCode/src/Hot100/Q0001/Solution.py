class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        n = len(nums)
        for i in range(n):
            x = nums[i]
            y = target - x
            if y in map:
                return [map.get(y), i]
            map[x] = i
        return [-1, -1]  # never
