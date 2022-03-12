package Q0599.Q0504Base7;

// recursion
public class Solution2 {
    public String convertToBase7(int num) {
        if (num < 0)
            return "-" + convertToBase7(-num);

        if (num < 7)
            return Integer.toString(num);
        else
            return Integer.toString(10 * Integer.parseInt(convertToBase7(num / 7)) + Integer.parseInt(convertToBase7(num % 7)));
    }
}