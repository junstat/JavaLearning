package Q0499.Q0482LicenseKeyFormatting.solution;

public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            if (cnt == k && (cnt = 0) >= 0) sb.append("-");
            sb.append(s.charAt(i));
            cnt++;
        }
        return sb.reverse().toString().toUpperCase();
    }
}
