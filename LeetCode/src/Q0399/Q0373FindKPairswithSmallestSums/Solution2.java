package Q0399.Q0373FindKPairswithSmallestSums;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {


    //1, 3, 5
    //2, 4, 6
    //1,2; 1,4; 3,2; 1,6; 3,4; 5,2; 3,6; 5,4; 5,6
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(nums1[0], nums2[0]));

        int idx1 = 0;
        int[] idx2 = new int[len1];
        idx2[0] = 1;
        while (result.size() < k) {
            while (idx1 < len1 && idx2[idx1] == len2) {
                idx1++;
            }
            if (idx1 == len1) {
                break;
            }

            int minSumIdx = 0;
            int minSum = Integer.MAX_VALUE;
            for (int i1 = idx1; i1 < len1; i1++) {
                if (idx2[i1] == len2) {
                    continue;
                }
                if (minSum > nums1[i1] + nums2[idx2[i1]]) {
                    minSum = nums1[i1] + nums2[idx2[i1]];
                    minSumIdx = i1;
                }
                if (idx2[i1] == 0) {
                    break; // Early terminate because latter ones must not be smaller...
                }
            }
            result.add(Arrays.asList(nums1[minSumIdx], nums2[idx2[minSumIdx]++]));
        }
        return result;
    }
}
