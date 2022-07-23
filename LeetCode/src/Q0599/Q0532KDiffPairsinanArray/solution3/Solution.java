package Q0599.Q0532KDiffPairsinanArray.solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    static int[] cnt = new int[10010];

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) list.add(i);
        }
        Arrays.fill(cnt, 0);
        for (int i : nums) cnt[Collections.binarySearch(list, i)]++;
        int n = list.size(), idx = 0, ans = 0, l = 0, r = 0;
        for (int i : list) {
            if (k == 0) {
                if (cnt[idx] > 1) ans++;
            } else {
                int a = i - k, b = i + k;
                while (l < n && list.get(l) < a) l++;
                while (r < n && list.get(r) < b) r++;
                if (l < n && list.get(l) == a && cnt[l] > 0) ans++;
                if (r < n && list.get(r) == b && cnt[r] > 0) ans++;
            }
            cnt[idx++] = 0;
        }
        return ans;
    }
}