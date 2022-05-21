package Q0499.Q0470ImplementRand10UsingRand7;

public class Solution2 extends SolBase {
    int curr = 1;

    public int rand10() {
        return curr = (curr + rand7()) % 10 + 1;
    }
}
