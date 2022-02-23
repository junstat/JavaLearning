package Q0299.Q0284PeekingIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution1 {
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator1 implements Iterator<Integer> {
    private List<Integer> nums;
    private int idx;
    private int len;

    public PeekingIterator1(Iterator<Integer> iterator) {
        // initialize any member here.
        nums = new ArrayList<>();
        idx = 0;
        while (iterator.hasNext())
            nums.add(iterator.next());
        len = nums.size();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nums.get(idx);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return nums.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < len;
    }
}