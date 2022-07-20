package Q0099.Q0065ValidNumber.solution3;

import java.util.Arrays;
import java.util.List;

/*
    DFA: Deterministic Finite Automaton 确定有限状态自动机
    States
    0: initial
    1: only dot
    2: number
    3: sign
    4: dot number
    5: e
    6: e sign
    7: e number
    8: end
    9: fail

    Inputs
    0: others
    1: space
    2: dot
    3: numbers
    4: sign
    5: e
 */
public class Solution {

    boolean isNumber(String s) {
        int state = 0;
        int[][] transitions = {
//               0, 1, 2, 3, 4, 5
                {9, 0, 1, 2, 3, 9}, // 0
                {9, 9, 9, 4, 9, 9}, // 1
                {9, 8, 4, 2, 9, 5}, // 2
                {9, 9, 1, 2, 9, 9}, // 3
                {9, 8, 9, 4, 9, 5}, // 4
                {9, 9, 9, 7, 6, 9}, // 5
                {9, 9, 9, 7, 9, 9}, // 6
                {9, 8, 9, 7, 9, 9}, // 7
                {9, 8, 9, 9, 9, 9}, // 8
                {9, 9, 9, 9, 9, 9}  // 9
        };

        for (int i = 0; i < s.length(); i++) {
            int input = getInput(s.charAt(i));
            state = transitions[state][input];
            if (state == 9) return false;
        }

        List<Integer> accepts = Arrays.asList(2, 4, 7, 8);
        return accepts.contains(state);

    }

    private int getInput(char c) {
        if (c == ' ') return 1;
        if (c == '.') return 2;
        if (c >= '0' && c <= '9') return 3;
        if (c == '+' || c == '-') return 4;
        if (c == 'e' || c == 'E') return 5;
        return 0;
    }
}
