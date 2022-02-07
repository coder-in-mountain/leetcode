import java.util.Arrays;

public class Solution {

    public static int selectRecursive(int[] array, int n) {
        return recursive(array, 0, array.length - 1, n);
    }

    static int recursive(int[] arr, int left, int right, int n) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = randomPivot(left,right);
        pivotIndex = partition(arr, left, right, pivotIndex);

    }

    /**
     *
     */
    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right); // move pivot to end
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] array, int a, int b) {
    		int tmp = array[a];
    		array[a] = array[b];
    		array[b] = tmp;
    }
}