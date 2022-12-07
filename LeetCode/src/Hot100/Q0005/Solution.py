class Solution:
    def longestPalindrome(self, s: str) -> str:
        t = self.pre_process(s)
        n = len(t)
        p = [0 for _ in range(n)]
        c, r, l, start = 0, 0, 1, 0
        for i in range(1, n - 1):
            i_m = 2 * c - i
            p[i] = min(r - i, p[i_m]) if i < r else 0
            while t[i + p[i] + 1] == t[i - p[i] - 1]:
                p[i] += 1
            if i + p[i] > r:
                c = i
                r = i + p[i]
            if p[i] > l:
                l = p[i]
                start = (i - p[i]) // 2
        return s[start: start + l]

    def pre_process(self, s: str) -> str:
        n = len(s)
        if n == 0:
            return "^$"
        ans = "^"
        for c in s:
            ans += f'#{c}'
        ans += "#$"
        return ans
