package Q0099.Q0093.solution1;

import java.util.ArrayList;
import java.util.List;

/*
   3-loop divides the string s into 4 substring: s1, s2, s3, s4. Check if each substring is valid.
   In isValid, strings whose length greater than 3 or equals to 0 is not valid; or if the string's length is longer
   than 1 and the first letter is '0' then it's invalid;
   or the string whose integer representation greater than 255 is invalid.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        return s.length() <= 3 &&
                s.length() != 0 &&
                (s.charAt(0) != '0' || s.length() <= 1) &&
                Integer.parseInt(s) <= 255;
    }
}
