package Q0499.Q0470ImplementRand10UsingRand7;


import java.util.Random;

class SolBase {
    public int rand7() {
        Random rand = new Random();
        return rand.nextInt(8);
    }
}

// Idea: rand7() -> rand49() -> rand40() -> rand10()
public class Solution1 extends SolBase {
    public int rand10() {
        for (; ; ) {
            int rand = 7 * (rand7() - 1) + (rand7() - 1);
            if (rand < 40) return rand % 10 + 1;
        }
    }
}