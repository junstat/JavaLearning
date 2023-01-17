package Q1899.Q1825FindingMKAverage.solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MKAverage {
    private Node st;
    private Node end;
    private Node left;
    private Node right;
    private TreeMap<Integer, Node> map;
    private List<Integer> list;
    private long sum;
    private int m;
    private int k;
    private int size;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.map = new TreeMap<>();
        this.list = new ArrayList<>();
        this.st = new Node(0);
        this.end = new Node(Integer.MAX_VALUE);
        this.left = st;
        this.right = end;
        this.size = m - (k << 1);
        st.next = end;
        end.pre = st;
        map.put(0, st);
        map.put(Integer.MAX_VALUE, end);
    }

    public void addElement(int num) {
        list.add(num);
        int s = list.size();
        Node value = map.floorEntry(num).getValue();
        Node node = new Node(num);
        map.put(num, node);
        if (s <= m) {
            addNext(value, node);
            if (s == m) {
                int i = k;
                while (i >= 0) {
                    this.left = this.left.next;
                    i--;
                    this.right = this.right.pre;
                }

                i = size;
                Node item = left;
                while (i > 0) {
                    sum += item.val;
                    item = item.next;
                    i--;
                }
            }
        } else {
            int val = value.val;
            addNext(value, node);
            if (val >= right.val) {
                right = right.next;
                sum += right.val;
            } else if (val >= left.val) {
                sum += num;
            } else {
                left = left.pre;
                sum += left.val;
            }
            int v = list.get(list.size() - 1 - m);
            Node no = map.get(v);
            if (no == left) {
                sum -= left.val;
                left = left.next;
            } else if (v >= right.val) {
                sum -= right.val;
                right = right.pre;
            } else if (v >= left.val) {
                sum -= v;
            } else {
                sum -= left.val;
                left = left.next;
            }
            Node pre = no.pre;
            if (pre.val == v) {
                map.put(v, pre);
            } else {
                map.remove(v);
            }
            delNext(pre);
        }
    }

    private void delNext(Node value) {
        Node next = value.next.next;
        value.next = next;
        next.pre = value;
    }

    private void addNext(Node value, Node node) {
        Node next = value.next;
        value.next = node;
        node.pre = value;
        node.next = next;
        next.pre = node;
    }

    public int calculateMKAverage() {
        if (list.size() < m) {
            return -1;
        }
        return (int) (sum / size);
    }

    private static class Node {
        private int val;
        private Node next;
        private Node pre;

        public Node(int val) {
            this.val = val;
        }
    }
}