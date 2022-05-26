package Q0299.Q0274HIndex;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given an array of integers citations where citations[i] is the number of citations a researcher received for
    their ith paper, return compute the researcher's h-index.
    According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at
    least h citations each, and the other n − h papers have no more than h citations each.
    If there are several possible values for h, the maximum one is taken as the h-index.

    Example 1:
    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5
    citations respectively.
    Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3
    citations each, their h-index is 3.

    Example 2:
    Input: citations = [1,3,1]
    Output: 1
 */
public class Review {

    @Test
    public void test1() {
        int[] citations = {3, 0, 6, 1, 5};
        assertEquals(3, hIndex(citations));
    }

    public int hIndex(int[] citations) {

        return 0;
    }
}
