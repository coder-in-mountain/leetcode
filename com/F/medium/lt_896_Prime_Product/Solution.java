import java.util.*;

public class Solution {
    /**
     * @param arr: The prime array
     * @return: Return the array of all of prime product
     */
    public int[] getPrimeProduct(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= arr.length; i++)
        dfs(arr, 0, i, 1, list);
        int len = list.size();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    void dfs(int[] arr, int start, int k, int product, ArrayList<Integer> list) {
        if (k == 0) {
            list.add(product);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            product *= arr[i];
            dfs(arr, i+1, k-1, product, list);
            product /= arr[i];
        }
    }
}