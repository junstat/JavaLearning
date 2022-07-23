package Q0199.Q0165CompareVersionNumbers.solution;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] verParts1 = version1.split("\\.");
        String[] verParts2 = version2.split("\\.");

        int len = Math.max(verParts1.length, verParts2.length);
        for (int i = 0; i < len; i++) {
            Integer v1 = i < verParts1.length ? Integer.parseInt(verParts1[i]) : 0;
            Integer v2 = i < verParts2.length ? Integer.parseInt(verParts2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) return compare;
        }

        return 0;
    }
}
