from typing import Optional

from Hot100.Datastructure.ListNode import ListNode


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        p, q = l1, l2
        dummy = ListNode(0)
        r = dummy
        _val = 0
        while p is not None or q is not None:
            a = 0 if p is None else p.val
            b = 0 if q is None else q.val
            _val += a + b
            r.next = ListNode(_val % 10)
            r = r.next
            _val //= 10
            if p is not None:
                p = p.next
            if q is not None:
                q = q.next
        if _val != 0:
            r.next = ListNode(_val)
        return dummy.next
