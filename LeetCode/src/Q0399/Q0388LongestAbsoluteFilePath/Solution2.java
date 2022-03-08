package Q0399.Q0388LongestAbsoluteFilePath;

// An even shorter and faster solution using array instead of stack:
public class Solution2 {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1, curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }
}
