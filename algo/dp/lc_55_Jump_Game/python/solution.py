class Solution:
    def canJump(self, nums: List[int]) -> bool:
        step = nums[0]
        i = 1
        n = len(nums)
        while i <= step and i < n:
            step = max(step, i + nums[i])
            i += 1
        return i >= n

