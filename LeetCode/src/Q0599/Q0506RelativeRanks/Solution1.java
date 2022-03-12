package Q0599.Q0506RelativeRanks;

import java.util.Arrays;

/*
    Basically this question is to find out the score -> ranking mapping. The easiest way is to sort those scores in
    nums. But we will lose their original order. We can create (score , original index) pairs and sort them by score
    decreasingly. Then we will have score -> ranking (new index) mapping and we can use original index to create the
    result.

    Time complexity: O(NlgN). Space complexity: O(N). N is the number of scores.

    Example:
    nums[i]    : [10, 3, 8, 9, 4]
    pair[i][0] : [10, 3, 8, 9, 4]
    pair[i][1] : [ 0, 1, 2, 3, 4]

    After sort:
    pair[i][0] : [10, 9, 8, 4, 3]
    pair[i][1] : [ 0, 3, 2, 4, 1]
 */
public class Solution1 {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            } else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            } else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            } else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }
}