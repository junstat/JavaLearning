package Q06.solution2;

import DataStructure.ListNode;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        if (head == null) return ans;
        printListFromTailToHead(head.next);
        ans.add(head.val);
        return ans;
    }
}
