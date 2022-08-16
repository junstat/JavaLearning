import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in

vowel_string = "aeiouAEIOU"


def flaw_degree(string):
    degree = 0
    for i in string:
        if i in vowel_string:
            continue
        degree += 1
    return degree


def longest_alp(degree, string):
    vowel_string = "aeiouAEIOU"
    head, length, tail = 0, 0, len(string) - 1

    result = []
    while head <= tail:
        if string[head].startswith(tuple(vowel_string)) and string[tail].endswith(tuple(vowel_string)):
            result.append(string[head:tail + 1])
            if string[head + 1].startswith(tuple(vowel_string)):
                tail -= 1
            else:
                head += 1
        elif string[head].startswith(tuple(vowel_string)) and not string[tail].endswith(tuple(vowel_string)):
            tail -= 1
        else:
            head += 1

    for item in result:
        if flaw_degree(item) == degree:
            length = max(length, len(item))
    return length


while True:
    try:
        k = int(input().strip())
        s = input().strip()
        print(longest_alp(k, s))
    except Exception as e:
        break
