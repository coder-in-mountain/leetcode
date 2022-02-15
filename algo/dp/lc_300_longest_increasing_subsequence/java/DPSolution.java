public class DPSolution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sub.get(sub.size() -1)) {
                sub.add(nums[i]);
            }else{
                int j = 0;
                while (nums[i] > sub.get(j)) {
                    j++;
                }
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }
}