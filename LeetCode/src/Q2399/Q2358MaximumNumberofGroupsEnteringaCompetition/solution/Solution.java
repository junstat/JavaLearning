package Q2399.Q2358MaximumNumberofGroupsEnteringaCompetition.solution;

public class Solution {
    public int maximumGroups(int[] grades) {
        int k = 0, total = 0, n = grades.length;
        while (total + k + 1 <= n)
            total += ++k;
        return k;
    }
}