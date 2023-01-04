package Q1899.Q1802MaximumValueataGivenIndexinaBoundedArray.solution1;

public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        int ans = 1;
        // 整个数组一开始全部填充为1，
        // rest记录先全部填充1后，剩下1的个数
        int rest = maxSum - n;
        while (l > 0 || r < n - 1) {
            int len = r - l + 1;
            if (rest >= len) {
                // 当前[l,r]范围全部+1
                rest -= len;
                ans++;
                // 往左右两边扩
                l = Math.max(0, l - 1);
                r = Math.min(n - 1, r + 1);
            } else {
                break;
            }
        }
        // 扩大到整个数组之后，剩余的值“雨露均沾”一下
        ans += rest / n;
        return ans;
    }
}