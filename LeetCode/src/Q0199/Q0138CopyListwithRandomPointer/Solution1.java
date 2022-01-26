package Q0199.Q0138CopyListwithRandomPointer;


/*
    As an optimised solution, we could reduce the space complexity into constant. The idea is to associate the
    original node with its copy node in a single linked list. In this way, we don't need extra space to keep track of
    the new nodes.

    The algorithm is composed of the follow three steps which are also 3 iteration rounds.
    1) Iterate the original list and duplicate each node. The duplicate of each node follows its original immediately.
    2) Iterate the new list and assign the random pointer for each duplicated node.
    3) Restore the original list and extract the duplicated nodes.
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        Node iter = head, next;

        /*
            First round: make copy of each node,
            and link them together side-by-side in a single list.
         */
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        // second round: assign random pointers for the copy nodes
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list
        iter = head;
        Node dummy = new Node(0);
        Node copy, copyIter = dummy;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return dummy.next;
    }
}