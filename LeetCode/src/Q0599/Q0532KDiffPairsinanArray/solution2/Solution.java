package Q0599.Q0532KDiffPairsinanArray.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static int[] cnt = new int[10010];
    List<Integer> list;

    int find(int x) {
        int n = list.size(), l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return list.get(r) == x ? r : -1;
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        list = new ArrayList<>();
        for (int i : nums) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) list.add(i);
        }
        Arrays.fill(cnt, 0);
        for (int i : nums) cnt[find(i)]++;
        int ans = 0, idx = 0;
        for (int i : list) {
            if (k == 0) {
                if (cnt[idx] > 1) ans++;
            } else {
                int a = find(i - k), b = find(i + k);
                if (a != -1 && cnt[a] > 0) ans++;
                if (b != -1 && cnt[b] > 0) ans++;
            }
            cnt[idx++] = 0;
        }
        return ans;
    }
}
