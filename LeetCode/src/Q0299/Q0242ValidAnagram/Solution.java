package Q0299.Q0242ValidAnagram;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return String.valueOf(sCharArray).equals(String.valueOf(tCharArray));
    }
}
