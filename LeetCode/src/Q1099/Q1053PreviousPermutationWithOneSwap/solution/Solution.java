package Q1099.Q1053PreviousPermutationWithOneSwap.solution;

public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] <= arr[i]) continue;
            for (int j = n - 1; j >= i; j--) {
                if (arr[j] < arr[i - 1] && arr[j] != arr[j - 1]) {
                    int t = arr[i - 1];
                    arr[i - 1] = arr[j];
                    arr[j] = t;
                    return arr;
                }
            }
        }
        return arr;
    }
}
