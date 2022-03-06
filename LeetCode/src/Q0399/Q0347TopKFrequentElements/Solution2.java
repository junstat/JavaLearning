package Q0399.Q0347TopKFrequentElements;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int n : nums) {
            if (n < min)
                min = n;
            else if (n > max)
                max = n;
        }

        int[] counts = new int[max - min + 1];
        for (int n : nums)
            ++counts[n - min];

        //array of int lists
        List<Integer>[] count2num = new List[nums.length + 1];
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] == 0)
                continue;
            int n = i + min;//number whose count is count[i]
            if (count2num[counts[i]] == null)
                count2num[counts[i]] = new ArrayList<Integer>();
            count2num[counts[i]].add(n); //create list of numbers which have this count

        }

        int[] result = new int[k];
        for (int i = count2num.length - 1; i >= 0 && k > 0; i--) {
            if (count2num[i] != null) {
                for (int n : count2num[i]) {
                    result[--k] = n;
                    if (k == 0)
                        break;
                }
            }
        }
        return result;
    }
}
