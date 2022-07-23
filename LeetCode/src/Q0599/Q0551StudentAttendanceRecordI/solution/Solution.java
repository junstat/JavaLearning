package Q0599.Q0551StudentAttendanceRecordI.solution;

public class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0, cnt = 0; i < n; ) {
            char c = cs[i];
            if (c == 'A') {
                cnt++;
                if (cnt >= 2) return false;
            } else if (c == 'L') {
                int j = i;
                while (j < n && cs[j] == 'L') j++;
                int len = j - i;
                if (len >= 3) return false;
                i = j;
                continue;
            }
            i++;
        }
        return true;
    }
}