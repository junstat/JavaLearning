package Q0399.Q0331VerifyPreorderSerializationofaBinaryTree.solution2;

public class Solution {
    public boolean isValidSerialization(String s) {
        String[] ss = s.split(",");
        int n = ss.length;
        int in = 0, out = 0;
        for (int i = 0; i < n; i++) {
            if (!ss[i].equals("#")) out += 2;
            if (i != 0) in++;
            if (i != n - 1 && out <= in) return false;
        }
        return in == out;
    }
}