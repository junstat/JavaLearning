package Q1099.Q1054DistantBarcodes.solution;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        int n = barcodes.length;
        int num = 0, j = 0, i = 0;
        int tlen = n - 1;
        for (; i < tlen; ++i) {
            num = barcodes[i];
            if (num == barcodes[i + 1]) {

                j = i + 2;
                while (j < n && num == barcodes[j]) ++j;
                if (j == n) break;
                else swap(barcodes, i + 1, j);
            }
        }

        if (j < n) return barcodes;
        for (i = n - 1; i > 0; --i) {
            num = barcodes[i];
            if (num == barcodes[i - 1]) {

                j = i - 2;
                while (j > -1 && num == barcodes[j]) --j;
                if (j > -1) swap(barcodes, i - 1, j);
            }
        }
        return barcodes;
    }

    public void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}