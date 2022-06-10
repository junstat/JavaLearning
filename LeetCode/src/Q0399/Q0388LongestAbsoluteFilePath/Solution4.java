package Q0399.Q0388LongestAbsoluteFilePath;

import java.util.Arrays;

public class Solution4 {
    static int[] hash = new int[10010];

    public int lengthLongestPath(String s) {
        Arrays.fill(hash, -1);
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; ) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t' && ++level >= 0) i++;
            int j = i;
            boolean isDir = true;
            while (j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') isDir = false;
            }
            Integer cur = j - i;
            Integer prev = level - 1 >= 0 ? hash[level - 1] : -1;
            Integer path = prev + 1 + cur;
            if (isDir) hash[level] = path;
            else if (path > ans) ans = path;
            i = j + 1;
        }
        return ans;
    }
}
