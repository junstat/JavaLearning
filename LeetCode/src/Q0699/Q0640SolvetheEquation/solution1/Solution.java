package Q0699.Q0640SolvetheEquation.solution1;

public class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        String leftPart = parts[0], rightPart = parts[1];
        int[] leftVals = evaluate(leftPart), rightVals = evaluate(rightPart);
        int cntX = leftVals[0] - rightVals[0];
        int cntNum = leftVals[1] - rightVals[1];
        if (cntX == 0) {
            if (cntNum != 0) return "No solution";
            return "Infinite solutions";
        }
        int valX = (-cntNum) / cntX;
        return "x=" + valX;
    }

    int[] evaluate(String exp) {
        int[] ans = new int[2];
        String[] expElements = exp.split("(?=[-+])");

        for (String ele : expElements) {
            if ("+x".equals(ele) || "x".equals(ele)) ans[0]++;
            else if ("-x".equals(ele)) ans[0]--;
            else if (ele.contains("x")) ans[0] += Integer.parseInt(ele.substring(0, ele.indexOf("x")));
            else ans[1] += Integer.parseInt(ele);
        }
        return ans;
    }
}