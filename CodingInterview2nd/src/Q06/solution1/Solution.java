package Q06.solution1;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.Collection;

public class Solution {
    public int[] reversePrint(ListNode head) {
        int cnt = 0;
        for (ListNode p = head; p != null; p = p.next) cnt++;
        int[] ans = new int[cnt];
        for (ListNode p = head; p != null; p = p.next) ans[--cnt] = p.val;
        return ans;
    }
}