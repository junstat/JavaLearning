package Q0399.Q0381InsertDeleteGetRandomO1Duplicatesallowed;

import java.util.*;

public class Solution2 {
}

// Runtime: 26 ms, faster than 100.00% of Java online submissions for Insert Delete GetRandom O(1) - Duplicates allowed.
class RandomizedCollection2 {

    //4:54
    int[] buf;
    Map<Integer, Set<Integer>> num2pos;
    Random r;
    int cnt;

    public RandomizedCollection2() {
        buf = new int[20000];
        num2pos = new HashMap<>();
        r = new Random();
        cnt = 0;
    }

    public boolean insert(int val) {
        int p = cnt;
        buf[cnt++] = val;
        Set<Integer> pos = num2pos.getOrDefault(val, new HashSet<Integer>());
        pos.add(p);
        num2pos.put(val, pos);
        return pos.size() == 1;
    }

    public boolean remove(int val) {
        if (!num2pos.containsKey(val) || num2pos.containsKey(val) && num2pos.get(val).size() == 0) {
            return false;
        }
        Set<Integer> pos = num2pos.get(val);
        int p = pos.iterator().next();
        pos.remove(p);
        num2pos.put(val, pos);
        cnt--;
        if (p != cnt) {
            //System.out.println("pos size" + pos.size());
            int newV = buf[cnt];
            buf[p] = newV;

            pos = num2pos.get(newV);
            pos.remove(cnt);
            pos.add(p);
            num2pos.put(newV, pos);
        }
        return true;
    }

    public int getRandom() {
        return buf[r.nextInt(cnt)];
        //5:01
    }
}
