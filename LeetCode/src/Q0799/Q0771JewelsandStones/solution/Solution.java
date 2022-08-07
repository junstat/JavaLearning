package Q0799.Q0771JewelsandStones.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set<Character> setJ = new HashSet<>();
        for (char j : jewels.toCharArray())
            setJ.add(j);
        for (char s : stones.toCharArray())
            if (setJ.contains(s)) res++;
        return res;
    }
}
