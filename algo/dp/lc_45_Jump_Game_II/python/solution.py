class Solution:
    def jum(self, nums: List[int]) -> int:
        max_reach = 0
        count = 0
        i = 0
        while i < len(nums - 1):
            max_reach = i + nums[i]