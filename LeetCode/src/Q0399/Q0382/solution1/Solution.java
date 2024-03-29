package Q0399.Q0382.solution1;

import DataStructure.ListNode;

import java.util.Random;

public class Solution {
    ListNode head;
    Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for (int i = 1; c.next != null; i++) {
            c = c.next;
            if (random.nextInt(i + 1) == 0) r = c.val;
        }
        return r;
    }
}


