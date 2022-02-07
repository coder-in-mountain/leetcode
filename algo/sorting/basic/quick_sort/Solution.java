public class Solution {

    public void sort(int[] A) {
        if (A == null || A.length < 2) return;
        quicksort(A, 0, A.length - 1);
    }

    void quicksort(int[] A, int left, int right) {
        if (left < right) {
            int k = partition(A, left, right);
            quicksort(A, left, k-1);
            quicksort(A, k+1, right);
        }
    }

    int partition(int[] nums, int start, int end) {
        int pivot = nums[start];

        while (start < end) {
            while (start < end && nums[start] < base) {
                 start++;
            }
            while (start < end && nums[end] > base) {
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        nums[start] = base;
        return start;
    }

}