package Q0499.Q0470ImplementRand10UsingRand7;

import java.util.Random;

public class SolBase {
    public int rand7() {
        Random rand = new Random();
        return rand.nextInt(8);
    }
}