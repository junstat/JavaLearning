package Q0699.Q0648ReplaceWords.solution;

import java.util.List;

public class Solution {
    static class Node {
        Node[] tns = new Node[26];
        boolean isWord;
    }

    Node root = new Node();

    void addWord(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new Node();
            p = p.tns[u];
        }
        p.isWord = true;
    }

    String getWord(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return s;
            p = p.tns[u];
            if (p.isWord) return s.substring(0, i + 1);
        }
        return s;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();
        for (String s : dictionary) addWord(s);
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (i != 0) ans.append(' ');
            ans.append(getWord(words[0]));
        }
        return ans.toString();
    }
}