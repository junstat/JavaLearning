package Q0099.Q0007ReverseInteger;

public class Solution1 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
                return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
