public class QuickSelectSolution {

    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        return quickSelectKthLargest(nums, 0, nums.length - 1, k);
    }
    int quickSelectKthLargest(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);
        int rightCount = high - pivot + 1; // pivot is included
        if (rightCount == k) {
            return nums[pivot];
        }else if (rightCount < k) {
            return quickSelectKthLargest(nums, low, pivot - 1, k - rightCount);
        }
        return quickSelectKthLargest(nums, pivot+1, high, k);
    }

    int partition(int[] arr, int start, int end) {
        int pivot = start + (end - start)/2;
        if (pivot != end) {
            exch(arr, pivot, end);
            pivot = end;
        }
        while (start <= end) {
            if (arr[start] < arr[pivot]) {
                start++;
            }else if (arr[end] >= arr[pivot]) {
                end--;
            }else{
                exch(arr, start++, end--);
            }
        }
        exch(arr, start, pivot);

        return start;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}