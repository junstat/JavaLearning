import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    screen = 0
    buffer = 0
    select = 0
    for c in s:
        if c == '1':
            if select:
                screen = 1
            else:
                screen += 1
            select = 0
        elif c == '5':
            select = screen
        elif c == '2' and select != 0:
            buffer = select
        elif c == '3' and select != 0:
            screen -= select
            buffer = select
            select = 0
        elif c == '4':
            screen -= select
            screen += buffer
            select = 0

    print(screen)


for line in sys.stdin:
    solve(line.strip())
