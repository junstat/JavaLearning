package Q0299.Q0260SingleNumberIII.solution1;

import java.util.HashSet;
import java.util.Set;

/*
    因为重复的数字都只出现两次，用Set，第一次遇到添加到Set，第二次遇到，从Set中删除。最后在Set的即为所求。
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n))
                set.remove(n);
            else
                set.add(n);
        }

        int[] result = new int[2];
        int i = 0;
        for (int n : set)
            result[i++] = n;
        return result;
    }
}
