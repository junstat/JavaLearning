package Q0099.Q0065ValidNumber.solution2;

public class Solution {

    public boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*([e|E][-+]?\\d+)?");
    }
}
