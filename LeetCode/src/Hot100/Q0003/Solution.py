class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = {}
        ans = 0
        n = len(s)
        start, end = 0, 0
        while end < n:
            right = s[end]
            map[right] = map.get(right, 0) + 1
            while map.get(right) > 1:
                left = s[start]
                map[left] -= 1
                start += 1
            ans = max(ans, end - start + 1)
            end += 1
        return ans
