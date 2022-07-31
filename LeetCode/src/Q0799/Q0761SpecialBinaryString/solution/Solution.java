package Q0799.Q0761SpecialBinaryString.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1') count++;
            else count--;
            if (count == 0) {
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        res.sort(Collections.reverseOrder());
        return String.join("", res);
    }
}
