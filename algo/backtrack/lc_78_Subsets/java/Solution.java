class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, new int[i], ans);
        }
        return ans;
    }

    void dfs(int[] src, int index, int[] target, List<List<Integer> ans) {
        if (sIndex == target.length) {
            ans.add(Arrays.stream(target).boxed().collect(Collectors.toList()););
            return;
        }
        for (int i = sIndex; i < src.length; i++) {
            T[index] = src[i];
            dfs(src, index+1, target, ans);
        }
    }
}