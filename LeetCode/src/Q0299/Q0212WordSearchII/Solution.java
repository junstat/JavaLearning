package Q0299.Q0212WordSearchII;

import java.util.ArrayList;
import java.util.List;

/*
    Backtracking + Trie
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
        char c = board[i][j];
        if (c == '#' || p.children[c - 'a'] == null) return;
        p = p.children[c - 'a'];
        if (p.word != null) {       // found one
            result.add(p.word);
            p.word = null;      //  de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, result);
        if (j > 0) dfs(board, i, j - 1, p, result);
        if (i < board.length - 1) dfs(board, i + 1, j, p, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, result);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (p.children[c - 'a'] == null)
                    p.children[c - 'a'] = new TrieNode();
                p = p.children[c - 'a'];
            }
            p.word = w;
        }
        return root;
    }
}


class TrieNode {
    public String word;
    public TrieNode[] children = new TrieNode[26];
}