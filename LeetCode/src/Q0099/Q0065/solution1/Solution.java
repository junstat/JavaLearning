package Q0099.Q0065.solution1;

public class Solution {

    /*
        All we need is to have a couple of flags so we can process the string in liner time:
        We start with trimming.
        If we see `[0-9]` we reset the number flags.
        We can only see `.` if we didn't see `e` or `.`
        We can only see `e` if we didn't see `e` but we did see a number. We reset numberAfterE flag.
        We can only see + and - in the beginning and after an e
        any other character break the validation.
        At the end it is only valid if there was at least 1 number and if we did see an e then a number after it as
        well.

        So basically the number should match this regular expression:
        [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?

        The 'numberAfterE' is unnecessary.
     */
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;

        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) return false;
                numberSeen = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        return numberSeen;
    }
}
