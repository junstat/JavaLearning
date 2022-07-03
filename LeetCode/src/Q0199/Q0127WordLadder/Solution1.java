package Q0199.Q0127WordLadder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
This problem has a nice BFS structure. Let's illustrate this using the example in the problem statement.
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Since only one letter can be changed at a time, if we start from "hit", we can only change to those words which have
exactly one letter different from it (in this case, "hot"). Putting in graph-theoretic terms, "hot" is a neighbor of
"hit". The idea is simpy to start from the beginWord, then visit its neighbors, then the non-visited neighbors of
its neighbors until we arrive at the endWord. This is a typical BFS structure.

We may also start from the endWord simultaneously. Two-end BFS.

At last I'm able to understand. I learned a lot from this solution.
1) It's much faster than one-end search indeed as explained in wiki. https://en.wikipedia.org/wiki/Bidirectional_search
2) BFS isn't equivalent to Queue. Sometimes Set is more accurate representation for nodes of level. (also handy since
we need to check if we meet from two ends)
3) It's safe to share a visited set for both ends since if they meet same string it terminates early. (vis is useful
since we cannot remove word from dict due to bidirectional search)
4) It seems like if(set.add()) is a little slower than if(!contains()) then add() but it's more concise.
update: the dictList is of List type now. And all transformed words including endWord must be in dictList.
 */
public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }
}

