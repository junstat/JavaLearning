package Q1899.Q1803CountPairsWithXORinaRange.solution3;

public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie trie = new Trie();

        int ans = 0;
        for (int num : nums) {
            ans += trie.countLessThan(num, high + 1) - trie.countLessThan(num, low);
            trie.insert(num);
        }

        return ans;
    }

    public class Trie {
        static final int L = 15;
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int val) {
            TrieNode node = root;
            for (int i = L - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node.children[bit].count += 1;
                node = node.children[bit];
            }
        }

        public int countLessThan(int val, int limit) {
            int res = 0;
            TrieNode node = root;
            for (int i = L - 1; i >= 0 && node != null; i--) {
                int bit = (val >> i) & 1;

                if (((limit >> i) & 1) == 0) {
                    node = node.children[bit];
                } else { // limit bit value is 1
                    if (node.children[bit] != null) { // same bit value with val, xor result is 0, must be less than limit value
                        res += node.children[bit].count;
                    }
                    node = node.children[1 - bit];
                }
            }

            return res;
        }
    }

    public class TrieNode {
        private TrieNode[] children;
        private int count;

        public TrieNode() {
            children = new TrieNode[2];
            count = 0;
        }
    }
}