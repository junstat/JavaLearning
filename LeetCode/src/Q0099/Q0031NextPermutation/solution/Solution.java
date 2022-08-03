package Q0099.Q0031NextPermutation.solution;

class Solution {
    int[] nums;

    public void nextPermutation(int[] _nums) {
        nums = _nums;
        int n = nums.length, k = n - 1;
        while (k - 1 >= 0 && nums[k - 1] >= nums[k]) k--;
        if (k == 0) reverse(0, n - 1);
        else {
            int u = k;
            while (u + 1 < n && nums[u + 1] > nums[k - 1]) u++;
            swap(k - 1, u);
            reverse(k, n - 1);
        }
    }

    void reverse(int a, int b) {
        while (a < b) swap(a++, b--);
    }

    void swap(int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}