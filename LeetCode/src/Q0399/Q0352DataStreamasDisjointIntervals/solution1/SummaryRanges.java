package Q0399.Q0352DataStreamasDisjointIntervals.solution1;

import java.util.TreeMap;

/*
    Use TreeMap to easily find the lower and higher keys, the key is the start of the interval.
    Merge the lower and higher intervals when necessary. The time complexity for adding is O(logN) since lowerKey(),
    higherKey(), put() and remove() are all O(logN). It would be O(N) if you use an ArrayList and remove an interval
    from it.
 */
public class SummaryRanges {

    private final TreeMap<Integer, int[]> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if (l != null && h != null && tree.get(l)[1] + 1 == val && h == val + 1) {
            tree.get(l)[1] = tree.get(h)[1];
            tree.remove(h);
        } else if (l != null && tree.get(l)[1] + 1 >= val) {
            tree.get(l)[1] = Math.max(tree.get(l)[1], val);
        } else if (h != null && h == val + 1) {
            tree.put(val, new int[]{val, tree.get(h)[1]});
            tree.remove(h);
        } else {
            tree.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[tree.size()][2];
        int i = 0;
        for (int[] interval : tree.values()) {
            res[i++] = interval;
        }
        return res;
    }
}