import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(k, s):
    ans = []
    cur = ""
    for c in s:
        # 按下划线 双引号 拆分字符串
        if c == '_':
            if '"' not in cur and cur:
                ans.append(cur)
                cur = ""
            elif '"' in cur:
                cur += c
        elif c == '"':
            if cur and '"' in cur:
                cur += c
                ans.append(cur)
                cur = ""
            elif cur and '"' not in cur:
                ans.append(cur)
                cur = c
            elif not cur:
                cur = c
        else:
            cur += c

    if cur:
        ans.append(cur)

    # 替换指定下标的 子串为 6个星号
    if k < len(ans):
        out = s.replace(ans[k], "*" * 6)
        while "__" in out:
            out = out.replace("__", "_")
        print(out)
    else:
        print("ERROR")


while True:
    try:
        k = int(input().strip())
        s = input().strip()
        solve(k, s)
    except Exception as e:
        break
