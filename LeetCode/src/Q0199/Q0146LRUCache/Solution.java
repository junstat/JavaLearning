package Q0199.Q0146LRUCache;

import java.util.HashMap;
import java.util.Map;

public class Solution {
}

/*
    HashMap + 双向链表
    用HashMap存储元素。
    put一个元素，头插。如果get某个元素，就把这个元素移动到链表头部。当存满的时候，就移掉表尾。
 */
class LRUCache {

    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        if (map.size() == capacity)
            remove(tail.prev);
        insert(new Node(key, value));
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
