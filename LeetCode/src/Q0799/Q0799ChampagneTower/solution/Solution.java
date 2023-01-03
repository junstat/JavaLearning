package Q0799.Q0799ChampagneTower.solution;

import java.util.ArrayList;

public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;
        ArrayList<Double> prevRow = new ArrayList<>(poured);

        while (query_row-- > 0) {
            ArrayList<Double> curRow = new ArrayList<Double>();
            double champagneInEnds = Math.max(0, (prevRow.get(0) - 1) / 2); // min champagne can be 0;
            curRow.add(champagneInEnds);    // first glass

            for (int i = 1; i < prevRow.size(); i++)
                curRow.add(Math.max(0, (prevRow.get(i - 1) - 1) / 2) + // flow from top-left glass
                        Math.max(0, (prevRow.get(i) - 1) / 2)); // flow from top-right glass
            curRow.add(champagneInEnds);    // last glass
            prevRow = curRow;
        }
        return Math.min(1, prevRow.get(query_glass));   // max champagne can be 1
    }
}
