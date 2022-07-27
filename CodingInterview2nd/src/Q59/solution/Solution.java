package Q59.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[deque.peekFirst()]);
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) deque.pollFirst();
            ans.add(nums[deque.peekFirst()]);
        }
        return ans;
    }
}