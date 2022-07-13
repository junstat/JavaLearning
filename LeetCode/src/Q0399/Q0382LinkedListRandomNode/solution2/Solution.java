package Q0399.Q0382LinkedListRandomNode.solution2;

import DataStructure.ListNode;

import java.util.Random;

public class Solution {
    ListNode head;
    Random random = new Random(20220116);

    public Solution(ListNode _head) {
        head = _head;
    }

    public int getRandom() {
        int ans = 0, idx = 0;
        ListNode t = head;
        while (t != null && ++idx >= 0) {
            if (random.nextInt(idx) == 0) ans = t.val;
            t = t.next;
        }
        return ans;
    }
}