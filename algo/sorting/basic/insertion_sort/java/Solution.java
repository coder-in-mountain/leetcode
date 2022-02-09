import java.util.*;
public class Solution {
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int i = 0;
        while (i < arr.length) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            i++;
        }
    }
    void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }

    public static void main(String[] args) {
        t(new int[]{2, 5, 0, 1, 9, 7, 3});
        t(new int[]{2,-1, 5, 3, 8, 7, 13, 45, 32, 0, 9, 5});
    }

    static void t(int[] arr) {
        System.out.println(Arrays.toString(arr));
        new Solution().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}