package Q0099.Q0043MultiplyStrings;

public class Solution {

    /*
        若num1 m 位，num2 n 位，则num1 * num2 最大 m+n 位。
        如:
            9 9
          * 0 9
          ---------
          0 8 1 <-- num1[0] * num2[0] = result[0+0+1] * 10 ^ (0+0+1) + result[0+0] * 10 ^ (0+0)
          8 1 0 <-- num1[1] * num2[0] = result[1+0+1] * 10 ^(1+0+1) + result[1+0] * 10 ^ (1+0)
          ------------
          8 9 1 <-- result
         综上，num1[i] * num2[j] = result[i + j +1] * 10 ^ (i + j +1) + result[i+j] * 10 ^(i+j)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] productArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = product + productArr[p2];
                productArr[p1] += sum / 10;
                productArr[p2] = sum % 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num : productArr)
            if (builder.length() != 0 || num != 0)
                builder.append(num);
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
