class Solution:
    def minNumberOfFrogs(self, s: str) -> int:
        t = "croak"
        cnt = [0] * 5
        ans = 0
        cur = 0
        for c in s:
            n = t.find(c)
            cnt[n] += 1
            cnt[n - 1] -= 1
            if n == 0:
                cur += 1
                ans = max(ans, cur)
            elif cnt[n - 1] < 0:
                return -1
            elif n == 4:
                cur -= 1
        return -1 if cur != 0 else ans
