public class Solution {
    public int selectKthElement(int[] arr, int k) {
        int index = quickselect(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }
}