import math
import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def gcd(a, b):
    mod = 2
    while mod != 0:
        mod = a % b
        a = b
        b = mod
    return a


def solve1(m):
    ans = []
    for a in range(m + 1):
        for b in range(a + 1, m + 1):
            for c in range(b + 1, m + 1):
                if a ** 2 + b ** 2 == c ** 2 and gcd(a, b) == gcd(b, c) == gcd(a, c) == 1:
                    ans.append((a, b, c))
    print(len(ans))


def solve(n):
    m = int(math.sqrt(n))
    for i in range(1, m + 1):
        for j in range(i + 1, m + 1, 2):
            if gcd(j, i) == 1:
                a = j * j - i * i
                b = 2 * i * j
                c = i * i + j * j
                if c <= n:
                    print(f'{a} {b} {c}')
    print("-" * 50)


while True:
    try:
        m = int(input().strip())
        solve(m)
    except Exception as e:
        break
