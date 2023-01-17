package Q1899.Q1813SentenceSimilarityIII.solution;

public class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() > s2.length()) return areSentencesSimilar(s2, s1);
        String[] arr1 = s1.split(" "), arr2 = s2.split(" ");
        int n = arr1.length, m = arr2.length, l = 0, r = 0;
        while (l < n && arr1[l].equals(arr2[l])) l++;
        while (r < n - l && arr1[n - r - 1].equals(arr2[m - r - 1])) r++;
        return l + r == n;
    }
}
