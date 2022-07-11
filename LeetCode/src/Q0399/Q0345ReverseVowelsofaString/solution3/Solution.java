package Q0399.Q0345ReverseVowelsofaString.solution3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    static Set<Character> set = new HashSet<>();

    static {
        for (char c : vowels) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
    }

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (set.contains(cs[l]) && set.contains(cs[r])) {
                swap(cs, l++, r--);
            } else {
                if (!set.contains(cs[l])) l++;
                if (!set.contains(cs[r])) r--;
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
