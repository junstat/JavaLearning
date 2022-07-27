package Q39.solution1;

public class Solution {
    public int moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) return 0;

        int result = 0, times = 0;
        for (int num : array) {
            if (times == 0) {
                result = num;
                times = 1;
            } else if (num == result) times++;
            else times--;
        }
        times = 0;
        for (int num : array) if (num == result) times++;
        return times > array.length >> 1 ? result : 0;
    }
}