package Q2099.Q2042CheckifNumbersAreAscendinginaSentence.solution2;

public class Solution {
    public boolean areNumbersAscending(String s) {
        int pre = -1;
        for (String x : s.replaceAll("[a-z]", "").split(" ")) { //去掉字母后以空格分割
            if (x.length() <= 0) continue;
            if (Integer.parseInt(x) <= pre) return false;
            pre = Integer.parseInt(x);
        }
        return true;
    }
}