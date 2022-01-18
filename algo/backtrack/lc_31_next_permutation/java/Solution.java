import java.util.*;
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        int i = n-2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = n-1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);

        }
        reverse(nums, i+1, n-1);
    }

    void swap(int[] s, int a, int b) {
        int tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }

    void reverse(int[] s, int i, int j) {
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }
}