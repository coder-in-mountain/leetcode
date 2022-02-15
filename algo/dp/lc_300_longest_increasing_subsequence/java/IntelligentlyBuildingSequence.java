public class IntelligentlyBuildingSequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq.get(seq.size() - 1)) {
                seq.add(nums[i]);
            }else {
                // int j = 0;
                // while (nums[i] > seq.get(j)) {
                //     j++;
                // }
                int j = findFirstLargerThanElement(seq, nums[i]);
                seq.set(j, nums[i]);
            }
        }
        return seq.size();
    }

    int findFirstLargerThanElement(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (list.get(mid) <= target) {
                left = mid;
            }else{
                right = mid;
            }
        }
        if (list.get(left) >= target) {
            return left;
        }
        return right;
    }
    }
}