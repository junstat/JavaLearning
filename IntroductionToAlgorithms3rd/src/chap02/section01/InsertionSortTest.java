package chap02.section01;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {
    @Test
    public void test1() {
        int[] A = {5, 2, 4, 6, 1, 3};
        System.out.println("Before sorting: " + Arrays.toString(A));
        insertionSort(A);
        System.out.println("After sorting: " + Arrays.toString(A));
    }

    /*
     * Insertion-Sort(A)
     * for j = 1 to (A.length - 1)
     *      key = A[j]
     *      // Insert A[j] into the sorted sequence A[0, ..., j - 1].
     *      i = j - 1
     *      while i >= 0 and A[i] > key
     *          A[i + 1] = A[i]
     *          i = i - 1
     *      A[i + 1] = key
     */
    private void insertionSort(int[] A) {
        for (int j = 0; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key)
                A[i + 1] = A[i--];
            // 退出循环有两种情况:
            // case 1: i = -1, sorted part已经遍历完了
            // case 2: A[i] <= key，i+1 即为 key的插入位置
            A[i + 1] = key;
        }
    }
}
