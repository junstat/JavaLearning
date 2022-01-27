package Q0199.Q0169MajorityElement;

/*
    Moore Voting Algorithm
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        int counter = 0, majority = 0;
        for (int num : nums) {
            if (counter == 0) majority = num;
            counter += num == majority ? 1 : -1;
        }
        return majority;
    }
}
