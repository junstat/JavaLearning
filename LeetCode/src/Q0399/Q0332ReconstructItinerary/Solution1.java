package Q0399.Q0332ReconstructItinerary;

import java.util.*;

/*
    Just Eulerian path. Greedy DFS, building the route backwards when retreating.
    More explanation and example under the codes.

    https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
 */
public class Solution1 {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        return route;
    }

    private void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }
}
