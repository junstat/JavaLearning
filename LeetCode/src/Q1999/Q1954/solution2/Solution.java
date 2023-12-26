package Q1999.Q1954.solution2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Solution {
    @Test
    public void void1() {
        assertThat(minimumPerimeter(1), equalTo(8L));
        assertThat(minimumPerimeter(13), equalTo(16L));
    }

    public long minimumPerimeter(long neededApples) {
        long lo = 1, hi = (long) 1e5;
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;
            if (mid * 2 * (mid + 1) * (mid + mid + 1) < neededApples) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo * 8;
    }
}
