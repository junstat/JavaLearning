package Q0399.Q0341FlattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution1 {
}

class NestedIterator1 implements Iterator<Integer> {
    private List<Integer> nums;
    private Iterator<Integer> cur;

    public NestedIterator1(List<NestedInteger> nestedList) {
        nums = new ArrayList<>();
        dfs(nestedList);
        cur = nums.iterator();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                nums.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}
