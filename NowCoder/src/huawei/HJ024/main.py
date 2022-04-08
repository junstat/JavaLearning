import sys
import bisect  # 引入二分法

if sys.platform != "linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def inc_max(l):  # 定义一个函数，寻找最长的子序列
    arr = [l[0]]  # 定义列表，将传入函数的列表第一个元素放入当前元素
    dp = [1] * len(l)  # 定义一个列表，默认子序列有当前元素1，长度是传入函数的列表长度
    for i in range(1, len(l)):  # 从第二个元素开始查找
        if l[i] > arr[-1]:  # 如果元素大于arr列表的最后一个元素，就把它插入列表末尾
            arr.append(l[i])
            dp[i] = len(arr)  # 获取这个元素子序列的长度
        else:  # 否则，利用二分法找到比元素大的元素的位置，用新的元素替代比它大的那个元素的值，这样就能制造出一个顺序排列的子序列
            pos = bisect.bisect_left(arr, l[i])
            arr[pos] = l[i]
            dp[i] = pos + 1  # 获取这个元素子序列的长度
    return dp


while True:
    try:
        n = int(input())
        s = list(map(int, input().split()))
        left_s = inc_max(s)  # 向左遍历查找子序列
        right_s = inc_max(s[::-1])[::-1]  # 向右遍历查找子序列
        res = [left_s[i] + right_s[i] - 1 for i in range(len(s))]  # 因为左右都包含原元素，所以需要减1 ；得到各元素能得到的子序列的最大长度
        print(n - max(res))  # 源列表长度-可以生成的最长子序列长度  得到需要剔除的最小人数
    except:
        break
