package Q0299.Q0205IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicAux(s, t) && isIsomorphicAux(t, s);
    }

    public boolean isIsomorphicAux(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), t.charAt(i));
            if (map.get(s.charAt(i)) != t.charAt(i)) return false;
        }
        return true;
    }
}
