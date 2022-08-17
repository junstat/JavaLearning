import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in

for line in sys.stdin:
    s = line.strip()
    print(s.replace(" ", ","), end=",")
