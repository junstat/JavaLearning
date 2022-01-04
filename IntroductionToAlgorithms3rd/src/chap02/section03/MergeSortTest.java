package chap02.section03;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void test1() {
        int[] A = {5, 2, 4, 7, 1, 3, 2, 6};
        testMergeSort(A);
        int[] B = {5, 2, 4, 7, 1, 3, 2, 6, 8};
        testMergeSort(B);
    }

    public void testMergeSort(int[] A) {
        String lenToken = A.length % 2 == 0 ? "even" : "odd";
        System.out.printf("if A.length is %s: \n", lenToken);
        System.out.println("Before sorting: " + Arrays.toString(A));
        mergeSort(A);
        System.out.println("After sorting: " + Arrays.toString(A));
    }

    @Test
    public void testMerge() {
        int[] A = {2, 4, 5, 7, 1, 2, 3, 6};
        System.out.println("Before merge: " + Arrays.toString(A));
        merge(A, 0, 3, A.length - 1);
        System.out.println("Before merge: " + Arrays.toString(A));
    }

    private void mergeSort(int[] A) {
        mergeSortAux(A, 0, A.length - 1);
    }

    /*
     * Merge-Sort(A, p, r)
     * if p < r
     *      q = ceil((p + r) / 2)
     *      Merge-Sort(A, p, q)
     *      Merge-Sort(A, q + 1, r)
     *      Merge(A, p, q, r)
     */
    private void mergeSortAux(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortAux(A, p, q);
            mergeSortAux(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    /*
     * Merge(A, p, q, r)
     * n1 = q - p + 1
     * n2 = r - q
     * let L[1...n1 + 1] and R[1...n2 + 1] be new arrays
     * for i = 1 to n1
     *      L[i] = A[p+i-1]
     * for j = 1 to n2
     *      R[j] = A[q + j]
     * L[n1 + 1] = infinite
     * R[n2 + 1] = infinite
     * i = 1
     * j = 1
     * for k = p to r
     *      if L[i] <= R[j]
     *          A[k] = L[i]
     *          i = i + 1
     *      else A[k] = R[j]
     *          j = j + 1
     */
    private void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        // L[0, ..., n1 - 1] = A[p, q]
        // R[0, ..., n2 - 1] = A[q+1, r]
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        if (n1 >= 0) System.arraycopy(A, p, L, 0, n1);
        if (n2 >= 0) System.arraycopy(A, q + 1, R, 0, n2);

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) A[k] = L[i++];
            else A[k] = R[j++];
        }
    }
}
