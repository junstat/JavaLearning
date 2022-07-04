package Q0199.Q0166FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 转 long 计算，防止溢出
        long a = numerator, b = denominator;
        // 如果本身能够整除，直接返回计算结果
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder ans = new StringBuilder();
        // 如果其一为负数，先追加负号
        if (a * b < 0) ans.append('-');
        a = Math.abs(a);
        b = Math.abs(b);
        // 计算小数点前的部分，并将余数赋值给 a
        ans.append(a / b).append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a, ans.length());
            a *= 10;
            ans.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", ans.substring(0, u), ans.substring(u));
            }
        }
        return ans.toString();
    }
}