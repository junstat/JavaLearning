package Q0899.Q0826MostProfitAssigningWork.solution2;

import java.util.TreeMap;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        int best = 0, res = 0;
        for (Integer key : map.keySet()) {
            best = Math.max(map.get(key), best);
            map.put(key, best);
        }
        for (int j : worker) {
            res += map.floorEntry(j).getValue();
        }
        return res;
    }
}