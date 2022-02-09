import heapq
class Solution:
    """
    @:param a: the array a
    @:return return the maximum profit
    """
    def getAns(self, a):
        heap = []
        ans = 0
        for i in a:
            if heap and i > heap[0]:
                ans += i - heapq.heappop(heap)
                heapq.heappush(heap, i)
            heapq.heappush(heap, i)
        return ans