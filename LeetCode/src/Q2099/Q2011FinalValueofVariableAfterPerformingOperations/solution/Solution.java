package Q2099.Q2011FinalValueofVariableAfterPerformingOperations.solution;

public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') ans++;
            else ans--;
        }
        return ans;
    }
}