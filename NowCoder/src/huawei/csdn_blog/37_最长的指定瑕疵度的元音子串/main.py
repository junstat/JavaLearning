import sys

if sys.platform == "darwin":
    file_in = open("input.txt")
    sys.stdin = file_in

vowels = "aeiouAEIOU"


def flaw_degree(s):
    return len([x for x in s if x not in vowels])


def longest_alp(d, s):
    n = len(s)
    l, ans, r = 0, 0, n - 1

    result = []
    while l <= r:
        if s[l] in vowels and s[r] in vowels:
            result.append(s[l:r + 1])
            if l + 1 < n and s[l + 1] in vowels:
                r -= 1
            else:
                l += 1
        elif s[l] in vowels and s[r] not in vowels:
            r -= 1
        else:
            l += 1

    for item in result:
        if flaw_degree(item) == d:
            ans = max(ans, len(item))
    return ans


while True:
    try:
        k = int(input().strip())
        s = input().strip()
        out = longest_alp(k, s)
        print(f'k = {k}')
        print(f's = {s}')
        print(f'ans = {out}')
        print("-*-" * 20)
    except Exception as e:
        break
