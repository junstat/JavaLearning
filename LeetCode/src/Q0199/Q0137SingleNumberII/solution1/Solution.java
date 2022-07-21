package Q0199.Q0137SingleNumberII.solution1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1;
    }
}
