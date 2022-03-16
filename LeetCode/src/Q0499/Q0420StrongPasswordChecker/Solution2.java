package Q0499.Q0420StrongPasswordChecker;

public class Solution2 {
    public int strongPasswordChecker(String password) {
        int res = 0;
        int a = 1;
        int A = 1;
        int d = 1;
        char[] str = password.toCharArray();
        int[] cnts = new int[str.length];

        for (int i = 0; i < str.length; ) {
            if (Character.isLowerCase(str[i])) a = 0;
            if (Character.isUpperCase(str[i])) A = 0;
            if (Character.isDigit(str[i])) d = 0;

            int j = i;
            while (i < str.length && str[i] == str[j]) ++i;
            cnts[j] = i - j;
        }

        int totalMissing = a + A + d;

        if (str.length < 6) {
            res += totalMissing + Math.max(0, 6 - (str.length + totalMissing));
        } else {
            int overLen = Math.max(0, str.length - 20);
            int leftover = 0;
            res += overLen;

            for (int k = 1; k < 3; ++k) {
                for (int i = 0; i < str.length && overLen > 0; ++i) {
                    if (cnts[i] < 3 || cnts[i] % 3 != (k - 1)) {
                        continue;
                    }

                    cnts[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }

            for (int i = 0; i < str.length; ++i) {
                if (cnts[i] >= 3 && overLen > 0) {
                    int need = cnts[i] - 2;
                    cnts[i] -= overLen;
                    overLen -= need;
                }

                if (cnts[i] >= 3) {
                    leftover += cnts[i] / 3;
                }
            }

            res += Math.max(leftover, totalMissing);
        }

        return res;
    }
}
