package Q0199.Q0187RepeatedDNASequences.solution2;

import java.util.*;

/*
    方法一的基础上的优化，
    因为s只包含4种字符 A、C、G、T，对其进行编码，每个字符使用2个bit进行编码，具体地
    A -> 00, C -> 01, G -> 10, T -> 11
    则 10个字符需要 20个bit。
    遍历s，对 [i-9, i+1] 这10个字符进行编码，判断是否重复
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length(), cur = 0;
        if (len < 10) return new ArrayList<>();

        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        for (int i = 0; i < 9; i++) {
            cur = (cur << 2) | map.get(s.charAt(i));
        }

        for (int i = 9; i < len; i++) {
            cur = ((cur & 0x3ffff) << 2) | map.get(s.charAt(i));
            if (!seen.add(cur))
                repeated.add(s.substring(i - 9, i + 1));
        }

        return new ArrayList<>(repeated);
    }
}
