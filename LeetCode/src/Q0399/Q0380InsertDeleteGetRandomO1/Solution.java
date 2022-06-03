package Q0399.Q0380InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
}

class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();

    }

    public boolean insert(int val) {
        boolean contains = locs.containsKey(val);
        if (contains) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean contains = locs.containsKey(val);
        if (!contains) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1) { // not last one, swap last element with removed one
            int num = nums.get(nums.size() - 1);
            locs.put(num, loc);
            nums.set(loc, num);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

