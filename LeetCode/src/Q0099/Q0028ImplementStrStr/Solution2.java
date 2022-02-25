package Q0099.Q0028ImplementStrStr;

public class Solution2 {
    /*
        2. KMP，实现来自于算法导论
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        int[] next = getNext(needle);
        int k = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (k > -1 && needle.charAt(k + 1) != haystack.charAt(i))
                k = next[k];
            if (needle.charAt(k + 1) == haystack.charAt(i)) {
                k++;
                if (k == needle.length() - 1) return i - k;
            }
        }
        return -1;
    }

    private int[] getNext(String needle) {
        int n = needle.length();
        int[] next = new int[n];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (k > -1 && needle.charAt(k + 1) != needle.charAt(i))
                k = next[k];
            if (needle.charAt(k + 1) == needle.charAt(i))
                k++;
            next[i] = k;
        }
        return next;
    }
}
