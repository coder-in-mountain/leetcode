class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        self.color = [0] * n
        for i in range(n):
            if self.color[i] == 0 and not self.colored(i, graph, 1):
                return False
        return True

    def colored(self, now, graph, c):
        self.color[now] = c
        for nei in graph[now]:
            if self.color[nei] == 0 and not self.colored(nei, graph, -c):
                return False
            elif self.color[nei] == c:
                return False
        return True