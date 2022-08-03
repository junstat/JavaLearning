from typing import List

MAX_V = 101
INF = 100 * 101


class Solution:
    def __init__(self):
        self.d = []
        self.G = [[INF] * MAX_V for i in range(MAX_V)]

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        for line in times:
            u, v, w = line
            self.G[u][v] = w
        if not self.dijkstra(n, k):
            return -1
        return max(self.d[1:n + 1])

    def dijkstra(self, n, s):
        visited = [False] * MAX_V
        self.d = [INF] * MAX_V
        self.d[s] = 0
        for i in range(n):
            u = -1
            m = INF
            for j in range(1, n + 1):
                if not visited[j] and self.d[j] < m:
                    u = j
                    m = self.d[j]

            if u == -1:
                return False

            visited[u] = True
            for v in range(1, n + 1):
                opt = self.d[u] + self.G[u][v]
                if not visited[v] and self.G[u][v] != INF and opt < self.d[v]:
                    self.d[v] = opt
        return True


