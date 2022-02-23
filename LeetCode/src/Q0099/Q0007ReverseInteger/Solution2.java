package Q0099.Q0007ReverseInteger;

/*
    考虑溢出的情况，x = Integer.MAX_VALUE = 2147483647
    若反转则为 7463847412，当处理到最后一位2时，发生了溢出， 746384741 * 10 + 2 已经溢出为负
    再做逆计算也不可能等于 746384741
 */
public class Solution2 {
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
