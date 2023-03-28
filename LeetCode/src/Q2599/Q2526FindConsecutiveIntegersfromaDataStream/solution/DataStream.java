package Q2599.Q2526FindConsecutiveIntegersfromaDataStream.solution;

public class DataStream {
    private int v;
    private int k;
    private int n;

    public DataStream(int value, int _k) {
        v = value;
        k = _k;
        n = 0;
    }

    public boolean consec(int num) {
        if (v == num) n++;
        else n = 0;
        return n >= k;
    }
}
