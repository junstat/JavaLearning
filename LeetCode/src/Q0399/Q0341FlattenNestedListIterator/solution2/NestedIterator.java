package Q0399.Q0341FlattenNestedListIterator.solution2;

import Q0399.Q0341FlattenNestedListIterator.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/*
    A question before this is the Nested List Weight Sum, and it requires recursion to solve. As it carries to this
    problem that we will need recursion to solve it. But since we need to access each NestedInteger at a time, we
    will use a stack to help.

    In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, it
    returns the very first element. Second, in the hasNext() function, we peek the first element in stack currently,
    and if it is an Integer, we will return true and pop the element. If it is a list, we will further flatten it.
    This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.

    Note: first version of the solution has some mistakes as mentioned in some of the comments below, updated it and
    apologize if it was misleading.
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }


    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.poll().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }
}