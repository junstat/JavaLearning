import random
import sys

if sys.platform != "Linux":
    file_in = open("lc.txt")
    sys.stdin = file_in

questions = [x.strip() for x in sys.stdin]
n = len(questions)
ans = random.sample(questions, n // 2)
for x in ans:
    print(x)
