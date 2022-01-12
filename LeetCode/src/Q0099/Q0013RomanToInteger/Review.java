package Q0099.Q0013RomanToInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    [Easy]
    Example 1:
    Input: s = "III"
    Output: 3
    Explanation: III = 3.

    Example 2:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    Example 3:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Review {
    @Test
    public void test1() {
        /*
          Input: s = "MCMXCIV"
          Output: 1994
          Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
          以CM = 900为例
          策略: 从右往左遍历，M = 1000, C = 100, 若出现逆序，则作差， CM = 1000 - 100 = 900.
        */
        String s = "MCMXCIV";
        assertEquals(romanToInt(s), 1994);
    }

    public int romanToInt(String s) {

        return 0;
    }
}
