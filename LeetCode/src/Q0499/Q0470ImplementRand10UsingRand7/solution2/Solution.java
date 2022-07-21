package Q0499.Q0470ImplementRand10UsingRand7.solution2;

import Q0499.Q0470ImplementRand10UsingRand7.SolBase;

public class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int ans = (rand7() - 1) * 7 + (rand7() - 1); // 进制转换
            if (1 <= ans && ans <= 40) return ans % 10 + 1;
        }
    }
}