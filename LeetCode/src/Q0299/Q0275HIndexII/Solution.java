package Q0299.Q0275HIndexII;

public class Solution {
    public int hIndex(int[] citations) {
        int lo = 0, n = citations.length, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] >= (n - mid)) hi = mid - 1;
            else lo = mid + 1;
        }
        return n - lo;
    }
}
