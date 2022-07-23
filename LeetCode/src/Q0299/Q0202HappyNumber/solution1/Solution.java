package Q0299.Q0202HappyNumber.solution1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        for (; ; ) {
            n = getNext(n);
            if (n == 1) return true;
            else if (set.contains(n)) return false;
            else set.add(n);
        }
    }

    // 计算各位数平方和
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        return sum;
    }
}
