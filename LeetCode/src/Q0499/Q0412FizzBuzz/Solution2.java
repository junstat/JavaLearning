package Q0499.Q0412FizzBuzz;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<String> fizzBuzz(int n) {
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0)
                arr[i] = "FizzBuzz";
            else if ((i + 1) % 3 == 0)
                arr[i] = "Fizz";
            else if ((i + 1) % 5 == 0)
                arr[i] = "Buzz";
            else
                arr[i] = String.valueOf(i + 1);
        }
        return Arrays.asList(arr);
    }
}
