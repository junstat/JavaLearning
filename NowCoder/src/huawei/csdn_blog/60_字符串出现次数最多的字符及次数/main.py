import sys
from collections import Counter

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in

for line in sys.stdin:
    s = line.strip()
    ans = Counter(s).most_common(1)[0]
    print(f'{ans[0]},{ans[1]}')
