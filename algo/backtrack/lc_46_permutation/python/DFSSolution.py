class DFSSolution:
    """
    Both time and space complexity are O(N!)
    """
    def permute(self, nums: List[int]) -> List[List[int]]:

        def backtrack(index = 0):
            if index == n:
                output.append(nums[:])
            for i in range(index, n):
                nums[index], nums[i] = nums[i], nums[index]
                backtrack(index+1)
                nums[index], nums[i] = nums[i], nums[index]
        n = len(nums)
        output = []
        backtrack()
        return output
