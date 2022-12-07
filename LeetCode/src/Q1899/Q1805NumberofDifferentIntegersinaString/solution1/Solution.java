package Q1899.Q1805NumberofDifferentIntegersinaString.solution1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (String str : word.split("[a-z]+")) if (str.length() > 0) set.add(str.replaceAll("^0+", ""));
        return set.size();
    }
}