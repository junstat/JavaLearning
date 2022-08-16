def check(num):
    a = num % 10
    b = num // 10 % 10
    c = num // 100
    return a ** 3 + b ** 3 + c ** 3 == num


s = "AXdddF"

nums = [ord(c) for c in s]
n = len(nums)
sums = [nums[0]]
for i in range(1, n):
    sums.append(sums[-1] + nums[i])

for x in sums:
    print(check(x))
