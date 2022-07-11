package Q0399.Q0345ReverseVowelsofaString.solution2;

public class Solution {
    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    static {
        for (char c : vowels) {
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (hash[cs[l] - ' '] && hash[cs[r] - ' ']) {
                swap(cs, l++, r--);
            } else {
                if (!hash[cs[l] - ' ']) l++;
                if (!hash[cs[r] - ' ']) r--;
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }
}
