package Q0199.Q0179LargestNumber.solution2;

import java.util.Arrays;

/*
    The idea here is basically implement a String comparator to decide which String should come first during
    concatenation. Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
    For example:
    String s1 = "9";
    String s2 = "31";

    String case1 =  s1 + s2; // 931
    String case2 = s2 + s1; // 319

    Apparently, case1 is greater than case2 in terms of value.
    So, we should always put s1 in front of s2.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(strings).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}
