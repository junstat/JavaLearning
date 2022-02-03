package Q0199.Q0187RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    对方法一的优化，使用3个bit编码 字符
    char    十进制    二         八      十六
    A       65      1000001     101     41
    C       67      1000011     103     43
    G       71      1000111     107     47
    T       84      1010100     124     54

    观察上表二进制一列，发现通过最低3 bit即可区分4个字符，故使用这3个bit编码。
 */
public class Solution3 {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Boolean> seen = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int cur = 0, i = 0; i < s.length(); i++) {
            cur = cur << 3 & 0x3FFFFFFF | (s.charAt(i) & 7);
            if (!seen.containsKey(cur)) {
                seen.put(cur, true);
                continue;
            }

            if (seen.get(cur)) {
                result.add(s.substring(i - 9, i + 1));
                seen.put(cur, false);
            }
        }
        return result;
    }
}
