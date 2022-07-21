package Q0199.Q0126WordLadderII.solution;

import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        final int wLen = beginWord.length();

        // build graph
        Map<String, List<String>> neighbors = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < wLen; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                neighbors.putIfAbsent(key, new ArrayList<String>());
                neighbors.get(key).add(word);
            }
        }

        // bfs to find all paths of shortest distance
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashMap<String, Integer> minDistances = new HashMap<>();
        minDistances.put(beginWord, 1);
        Map<String, List<String>> parents = new HashMap<>();
        parents.put(beginWord, null);
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int count = minDistances.get(word);
            if (minDistances.containsKey(endWord) && count >= minDistances.get(endWord)) {
                break; // cut-off when all paths leading to endWord found
            }
            if (visited.contains(word)) continue;
            visited.add(word);
            int nextCount = count + 1;
            for (int i = 0; i < wLen; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String nb : neighbors.getOrDefault(key, new ArrayList<String>())) {
                    if (!minDistances.containsKey(nb) || nextCount == minDistances.get(nb)) {
                        queue.add(nb);
                        minDistances.put(nb, nextCount);
                        parents.putIfAbsent(nb, new LinkedList<String>());
                        parents.get(nb).add(word);
                    }
                }
            }
        }

        // reverse dfs to retrieve shortest paths
        dfs(endWord, beginWord, parents, res, new LinkedList<String>());

        return res;
    }

    // dfs + backtracking
    private void dfs(final String cur, final String beginWord, final Map<String, List<String>> parents, final List<List<String>> res, final LinkedList<String> list) {
        list.addFirst(cur);
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<String>(list));
        } else {
            for (String parent : parents.getOrDefault(cur, new LinkedList<String>())) {
                dfs(parent, beginWord, parents, res, list);
            }
        }
        list.removeFirst();
    }
}