package Q2399.Q2347BestPokerHand.solution1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int suitCnt = 0;
        for (char suit : suits)
            if (suit == suits[0]) suitCnt++;
        if (suitCnt == 5) return "Flush";
        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) map.put(rank, map.getOrDefault(rank, 0) + 1);
        int maxValue = map.values().stream().max(Integer::compareTo).get();
        if (maxValue == 5 || maxValue == 4 || maxValue == 3) return "Three of a Kind";
        else if (maxValue == 2) return "Pair";
        else return "High Card";
    }
}
