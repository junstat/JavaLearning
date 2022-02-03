package Q0199.Q0166FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";     // zero numerator
        StringBuilder result = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) result.append("-");    // determine the sign
        long n = Math.abs((long) numerator), d = Math.abs((long) denominator);    // remove sign of operands
        result.append(n / d);       // append integral part
        if (n % d == 0) return result.toString();   // in case no fractional part
        result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        // simulate the division process
        for (long r = n % d; r != 0; r %= d) {
            // meet a known remainder
            // so we reach the end of the repeating part
            if (map.containsKey(r)) {
                int idx = map.get(r);
                return result.substring(0, idx) + "(" + result.substring(idx) + ")";
            } else {
                // the remainder is first seen
                // remember the current position for it
                map.put(r, result.length());
            }
            r *= 10;
            // append the quotient digit
            result.append(r / d);
        }
        return result.toString();
    }
}
