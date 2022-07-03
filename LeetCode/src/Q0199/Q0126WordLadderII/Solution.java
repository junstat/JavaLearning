package Q0199.Q0126WordLadderII;

import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) return res;
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        start.add(beginWord);
        end.add(endWord);
        bfs(map, start, end, dict, false);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(map, res, path, beginWord, endWord);
        return res;
    }

    private void bfs(Map<String, List<String>> map, Set<String> start, Set<String> end, Set<String> dict, boolean reverse) {
        if (start.isEmpty()) return;
        if (start.size() > end.size()) {
            bfs(map, end, start, dict, !reverse);
            return;
        }
        boolean finish = false;
        Set<String> nextLevel = new HashSet<>();
        dict.removeAll(start);
        for (String s : start) {
            char[] word = s.toCharArray();
            for (int i = 0; i < word.length; i++) {
                char old = word[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    word[i] = c;
                    String w = new String(word);
                    if (dict.contains(w)) {
                        if (end.contains(w)) finish = true;
                        else nextLevel.add(w);
                        String key = reverse ? w : s;
                        String val = reverse ? s : w;
                        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                        map.get(key).add(val);
                    }
                }
                word[i] = old;
            }
        }
        if (!finish) bfs(map, nextLevel, end, dict, reverse);
    }

    private void dfs(Map<String, List<String>> map, List<List<String>> res, List<String> path, String begin, String end) {
        if (begin.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!map.containsKey(begin)) return;
        for (String s : map.get(begin)) {
            path.add(s);
            dfs(map, res, path, s, end);
            path.remove(path.size() - 1);
        }
    }
}