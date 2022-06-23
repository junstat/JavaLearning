package Q0099.Q0014LongestCommonPrefix;

public class Solution3 {
    public String longestCommonPrefix(String[] ss) {
        StringBuilder ans = new StringBuilder();
        if (ss.length == 0) return ans.toString();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String s = ss[0];
            if (i >= s.length()) return ans.toString();
            char c = s.charAt(i);
            for (String item : ss) {
                if (i >= item.length() || item.charAt(i) != c) return ans.toString();
            }
            ans.append(String.valueOf(c));
        }
        return ans.toString();
    }
}

class Other {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
