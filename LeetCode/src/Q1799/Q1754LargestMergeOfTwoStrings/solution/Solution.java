package Q1799.Q1754LargestMergeOfTwoStrings.solution;

public class Solution {
    public String largestMerge(String w1, String w2) {
        StringBuilder sb = new StringBuilder();
        while (w1.length() + w2.length() > 0) {
            if (w1.compareTo(w2) > 0) {
                sb.append(w1.charAt(0));
                w1 = w1.substring(1);
            } else {
                sb.append(w2.charAt(0));
                w2 = w2.substring(1);
            }
        }
        return sb.toString();
    }
}
