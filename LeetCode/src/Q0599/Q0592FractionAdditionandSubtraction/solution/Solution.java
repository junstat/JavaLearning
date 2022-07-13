package Q0599.Q0592FractionAdditionandSubtraction.solution;

import org.junit.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String fractionAddition(String s) {
        List<int[]> frac = new ArrayList<>();
        int lcm = 1;    // least common multiple
        for (int i = 0, N = s.length(); i < N; ) {
            boolean neg = s.charAt(i) == '-';
            if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
            int num = 0, den = 0;
            while (Character.isDigit(s.charAt(i))) num = num * 10 + (s.charAt(i++) - '0');
            if (neg) num *= -1;
            ++i; // '/'
            while (i < N && Character.isDigit(s.charAt(i))) den = den * 10 + (s.charAt(i++) - '0');
            int d = gcd(lcm, den);
            lcm = lcm * den / d;
            frac.add(new int[]{num, den});
        }
        int num = 0;
        for (int[] f : frac) num += f[0] * (lcm / f[1]);
        String sign = num < 0 ? "-" : "";
        if (num < 0) num = -num;
        int d = gcd(num, lcm);
        return sign + (num / d) + "/" + (lcm / d);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
