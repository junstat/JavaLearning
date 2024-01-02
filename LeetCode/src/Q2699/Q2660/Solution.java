package Q2699.Q2660;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Solution {
    @Test
    public void test1() {
        int[] p1 = {4, 10, 7, 9};
        int[] p2 = {6, 5, 2, 3};
        assertThat(isWinner(p1, p2), equalTo(1));
    }

    @Test
    public void test2() {
        int[] p1 = {2, 3};
        int[] p2 = {4, 1};
        assertThat(isWinner(p1, p2), equalTo(0));
    }

    @Test
    public void test3() {
        int[] p1 = {3, 5, 7, 6};
        int[] p2 = {8, 10, 10, 2};
        assertThat(isWinner(p1, p2), equalTo(2));
    }

    public int isWinner(int[] player1, int[] player2) {
        int score1 = getScore(player1), score2 = getScore(player2);
        return score1 == score2 ? 0 : score1 > score2 ? 1 : 2;
    }

    int getScore(int[] nums) {
        int lastTen = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (lastTen != -1 && i - lastTen <= 2) {
                ans += 2 * a;
            } else {
                ans += a;
            }
            if (a == 10) lastTen = i;
        }
        return ans;
    }
}
