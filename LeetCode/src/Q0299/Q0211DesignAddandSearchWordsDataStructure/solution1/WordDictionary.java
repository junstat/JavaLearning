package Q0299.Q0211DesignAddandSearchWordsDataStructure.solution1;

public class WordDictionary {
    int N = 250000;
    int[][] tr = new int[N][26];
    boolean[] isWord = new boolean[N];
    int idx;

    public void addWord(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        isWord[p] = true;
    }

    public boolean search(String s) {
        return dfs(s, 0, 0);
    }

    boolean dfs(String s, int trIdx, int sIdx) {
        int n = s.length();
        if (sIdx == n) return isWord[trIdx];
        char c = s.charAt(sIdx);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (tr[trIdx][j] != 0 && dfs(s, tr[trIdx][j], sIdx + 1)) return true;
            }
            return false;
        } else {
            int u = c - 'a';
            if (tr[trIdx][u] == 0) return false;
            return dfs(s, tr[trIdx][u], sIdx + 1);
        }
    }
}
