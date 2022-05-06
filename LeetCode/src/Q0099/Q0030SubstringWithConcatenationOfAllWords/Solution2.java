package Q0099.Q0030SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) return result;
        char[] sArr = s.toCharArray();
        Map<MyString, Integer> counter = new HashMap<>();
        for (String value : words) {
            MyString word = new MyString(value);
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        int listLen = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= s.length() - wordLen * listLen; j += wordLen) {
                Map<MyString, Integer> segmentCounter = new HashMap<>();
                // 从尾往头遍历，判断往后第 k 个 len 位置的子串是否在 map 中
                for (int k = listLen - 1; k >= 0; k--) {
                    MyString segment = new MyString(sArr, j + k * wordLen, wordLen);
                    int val = segmentCounter.getOrDefault(segment, 0) + 1;
                    // 如果从 j+k*wordLen, j 到 (k+1)*wordLen 位置的子串不在 map 中
                    // 代表可以从 j 到 j+(k+1)*wordLen 这一段都可以舍弃
                    // 这里只需把 j 移动 k*wordLen，剩余的一个 wordLen 在循环体中移动。
                    if (val > counter.getOrDefault(segment, 0)) {
                        j += k * wordLen;
                        break;
                    }
                    // k到0代表找到了符合的子串
                    if (k == 0) result.add(j);
                    else segmentCounter.put(segment, val);
                }
            }
        }
        return result;
    }

    private static class MyString {
        private final char[] value;
        private final int offset;
        private final int len;
        private final int hashCode;

        MyString(String s) {
            this(s.toCharArray(), 0, s.length());
        }

        MyString(char[] value, int offset, int len) {
            this.value = value;
            this.offset = offset;
            this.len = len;
            int h = 0;
            for (int i = 0; i < len; i++) h = 31 * h + value[offset + i];
            this.hashCode = h;
        }

        public int hashCode() {
            return hashCode;
        }

        public boolean equals(Object o) {
            if (o instanceof MyString) {
                MyString other = (MyString) o;
                if (len != other.len) return false;
                for (int i = offset, j = other.offset; i < len; ++i, ++j)
                    if (value[i] != other.value[j]) return false;
                return true;
            }
            return false;
        }
    }
}
