package Q06.solution1;

import DataStructure.ListNode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) ans.add(0, p.val);
        return ans;
    }
}