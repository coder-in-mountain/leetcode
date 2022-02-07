public class QuickSelectSolution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int low = 0, high = n - 1;
        while (low < high) {
            int pivot = partition(nums, low, high);
            if (pivot < k) {
                low = pivot + 1;
            }else if (pivot > k) {
                high = pivot - 1;
            }else{
                break;
            }
        }
        return nums[k];
    }
}