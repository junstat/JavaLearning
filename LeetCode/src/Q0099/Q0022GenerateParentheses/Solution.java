package Q0099.Q0022GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
    The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many
    close). Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. Each of these
    steps are recursively called.

    an example to understand this solution:
    (
    ((
    (((
    ((()
    ((())
    ((()))
    (()
    (()(
    (()()
    (()())
    (())
    (())(
    (())()
    ()
    ()(
    ()((
    ()(()
    ()(())
    ()()
    ()()(
    ()()()
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }

        if (open < max)
            backtrack(result, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(result, str + ")", open, close + 1, max);
    }
}
