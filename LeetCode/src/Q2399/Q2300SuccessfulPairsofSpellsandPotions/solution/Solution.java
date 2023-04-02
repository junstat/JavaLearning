package Q2399.Q2300SuccessfulPairsofSpellsandPotions.solution;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        var map = new TreeMap<Long, Integer>();
        int n = potions.length;
        map.put(Long.MAX_VALUE, n);
        for (int i = n - 1; i >= 0; i--) map.put((long) potions[i], i);
        for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];
            spells[i] = n - map.ceilingEntry(need).getValue();
        }
        return spells;
    }
}
