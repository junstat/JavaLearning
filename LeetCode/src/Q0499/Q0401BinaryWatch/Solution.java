package Q0499.Q0401BinaryWatch;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new LinkedList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                    res.add(h + (m < 10 ? ":0" : ":") + m);
        return res;
    }
}