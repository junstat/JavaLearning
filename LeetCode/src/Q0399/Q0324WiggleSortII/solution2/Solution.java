package Q0399.Q0324WiggleSortII.solution2;

public class Solution {
    int[] nums;
    int n;

    int qselect(int l, int r, int k) {
        if (l == r) return nums[l];
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) return qselect(l, j, k);
        else return qselect(j + 1, r, k - cnt);
    }

    void swap(int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    int getIdx(int x) {
        return (2 * x + 1) % (n | 1);
    }

    public void wiggleSort(int[] _nums) {
        nums = _nums;
        n = nums.length;
        int x = qselect(0, n - 1, n + 1 >> 1);
        int l = 0, r = n - 1, loc = 0;
        while (loc <= r) {
            if (nums[getIdx(loc)] > x) swap(getIdx(loc++), getIdx(l++));
            else if (nums[getIdx(loc)] < x) swap(getIdx(loc), getIdx(r--));
            else loc++;
        }
    }
}