class Solution:
    def longestIncreasingContinuousSubsequence(self, A):
        if not A:
            return 0
        longest, incr, desc = 1, 1, 1
        for i in range(1, len(A)):
            if A[i] > A[i-1]:
                incr += 1
                desc = 1
            elif A[i] < A[i-1]:
                incr = 1
                desc += 1
            else:
                incr, desc = 1, 1
            longest = max(longest, max(incr, desc))
        return longest

