package Q0399.Q0313SuperUglyNumber.solution5;

import java.util.PriorityQueue;

/*
    Can we do better? Theoretically yes, by keep the one candidates for each prime in a heap, it can improve the
    theoretical bound to O( log(k)N ), but in reality it's 58 ms. I think it's the result of using higher level
    object instead of primitive. Can be improved by writing an
    index heap (http://algs4.cs.princeton.edu/24pq/IndexMinPQ.java.html)
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int prime : primes) pq.add(new Num(prime, 1, prime));
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num next = pq.poll();
                pq.add(new Num(next.p * ugly[next.idx], next.idx + 1, next.p));
            }
        }

        return ugly[n - 1];
    }
}


class Num implements Comparable<Num> {
    int val;
    int idx;
    int p;

    public Num(int val, int idx, int p) {
        this.val = val;
        this.idx = idx;
        this.p = p;
    }

    @Override
    public int compareTo(Num other) {
        return this.val - other.val;
    }
}