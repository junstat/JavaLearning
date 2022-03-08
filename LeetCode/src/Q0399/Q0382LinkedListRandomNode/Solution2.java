package Q0399.Q0382LinkedListRandomNode;

import DataStructure.ListNode;

import java.util.ArrayList;

public class Solution2 {
    ArrayList<Integer> tmp;

    public Solution2(ListNode head) {
        this.tmp = new ArrayList<>();
        while (head != null) {
            tmp.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return tmp.get((int) (Math.random() * tmp.size()));
    }
}