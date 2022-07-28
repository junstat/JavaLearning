package Q0699.Q0676ImplementMagicDictionary.solution;

public class MagicDictionary {
    static class TrieNode {
        TrieNode[] tns = new TrieNode[26];
        boolean isWord;
    }

    TrieNode root = new TrieNode();

    void addWord(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.isWord = true;
    }

    boolean search(String s, int idx, int diff, TrieNode node) {
        if (diff > 1) return false;
        if (idx == s.length()) return node.isWord && diff == 1;
        for (int i = 0; i < 26; i++) {
            if (node.tns[i] == null) continue;
            if (search(s, idx + 1, diff + (s.charAt(idx) - 'a' == i ? 0 : 1), node.tns[i])) return true;
        }
        return false;
    }

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) addWord(s);
    }

    public boolean search(String searchWord) {
        return search(searchWord, 0, 0, root);
    }
}