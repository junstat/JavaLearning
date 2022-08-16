import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in

while True:
    try:
        s = input().strip()
        p = input().strip()
        print(s.index(p))
    except Exception as e:
        break
