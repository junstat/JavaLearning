package Q0699.Q0658FindKClosestElements.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, l = 0, r = n - k;
        while (l < r) {
            int mid = l + r >> 1;
            if (x - arr[mid] <= arr[mid + k] - x) r = mid;
            else l = mid + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = r; i < r + k; i++) ans.add(arr[i]);
        return ans;
    }
}
