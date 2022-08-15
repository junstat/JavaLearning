import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    t = "quack"
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


def solve2(s):
    base = "quack"
    cnt = [0] * len(base)
    dp = []
    for i in range(len(s)):
        index = base.index(s[i])
        if index == 0:  # s[i] == 'q'
            cnt[index] += 1
        else:
            if cnt[index - 1]:
                cnt[index - 1] -= 1
                cnt[index] += 1

            if base[-1] == s[i] and cnt[-1] != 0:  # s[i] == 'k'
                # 计算剩余字符串是否满足剩余的叫声
                temp = [t for t in cnt]
                temp[-1] = 0
                max_ = sum(temp)
                for j in range(i, len(s)):
                    index = base.index(s[j])
                    if temp[index - 1]:
                        temp[index - 1] -= 1
                        temp[index] += 1
                    if temp[-1] == max_:
                        break
                dp.append(temp[-1] + 1)
                cnt[-1] -= 1
    return max(dp) if dp else -1


def main():
    for s in sys.stdin:
        s = s.strip()
        ans = solve2(s)
        print(ans)


if __name__ == '__main__':
    main()
