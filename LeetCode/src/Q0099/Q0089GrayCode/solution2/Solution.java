package Q0099.Q0089GrayCode.solution2;

import java.util.LinkedList;
import java.util.List;

/*
    公式法
    设 x的二进制数表示为 B[n-1, ..., 0]
    对应格雷码为 G[n-1, ..., 0]
    转换公式： G[n-1] = B[n-1] 最高位保留
             G[i] = B[i+1] ^ B[i]  i in [0, ..., n-2]
    如,
        1 0 1 1 0
     ^    1 0 1 1
     --------------
        1 1 1 0 1

    所以，遍历 0 ~ 2^n - 1 ，利用公式转换
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) result.add(i ^ i >> 1);
        return result;
    }
}
