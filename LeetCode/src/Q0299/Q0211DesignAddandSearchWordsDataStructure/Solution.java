package Q0299.Q0211DesignAddandSearchWordsDataStructure;

public class Solution {
}

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}


class WordDictionary {

    private TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int start, TrieNode node) {
        for (int i = start; i < word.length() && node != null; i++) {
            if (word.charAt(i) != '.')
                node = node.children[word.charAt(i) - 'a'];
            else {
                TrieNode tmp = node;
                for (int j = 0; j < 26; j++) {
                    node = tmp.children[j];
                    if (search(word, i + 1, node)) return true;
                }
            }
        }
        return node != null && node.isWord;
    }
}