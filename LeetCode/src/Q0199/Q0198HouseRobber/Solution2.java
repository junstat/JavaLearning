package Q0199.Q0198HouseRobber;

public class Solution2 {
    public int rob(int[] nums) {
		/*
		 思路: Dynamic Programming
		 设f(k)=从前k个house中抢到的最大金额,A[i]=第i个house中的金额
		 n = 1, f(1) = A[1]
		 n = 2, f(2) = max(A[1], A[2])
		 n = 3, f(3) = A[3] + A[1], if rob the third house
		  		or f(3) = A[2] , if don't rob the third house
		 ==> transition equation: f(k) = max( (f(k-2) + A[k]), f(k-1))
		 Time complexity: O(n), where n is the length of nums.
		 Space complexity: O(1)
		 */
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
