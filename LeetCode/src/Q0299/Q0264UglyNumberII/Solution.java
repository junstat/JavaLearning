package Q0299.Q0264UglyNumberII;

/*
    分析:
    取n=10
    res = [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
    初始时，一定有 res[0] = 1
    然后，其他的元素由 1*2, 1*3, 1*5，可以构造出来。
    需要解决大小顺序以及重复问题。

    设置t2=0分别表示是由因子2构造的第t2个数(t2从0开始)
    同理可以设置 t3, t5。
    由min(res[t2], res[t3], res[t5])可以解决大小序及重复问题。
 */
public class Solution {

    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int t2 = 0, t3 = 0, t5 = 0; // pointers for 2, 3, 5
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[n - 1];
    }
}
