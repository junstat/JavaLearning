package Q05.solution;

class Solution {
    public String replaceSpace(String str) {
        if (str == null || str.length() == 0) return str;
        int blanks = 0;

        for (char c : str.toCharArray()) if (c == ' ') blanks++;
        if (blanks == 0) return str;
        int tot = str.length() + 2 * blanks;
        char[] ans = new char[tot];
        for (int i = str.length() - 1, j = tot - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                ans[j--] = '0';
                ans[j--] = '2';
                ans[j--] = '%';
            } else ans[j--] = str.charAt(i);
        }
        return new String(ans);
    }
}
