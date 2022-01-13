package Q0099.Q0065ValidNumber;

public class Solution1 {

    public boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*([e|E][-+]?\\d+)?");
    }
}
