package Q0299.Q0284PeekingIterator;

import java.util.Iterator;

public class Review {
}


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIteratorReview implements Iterator<Integer> {
    public PeekingIteratorReview(Iterator<Integer> iterator) {
        // initialize any member here.

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {

        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {

        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}