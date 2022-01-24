public class Solution {
    /**
     * @param arr: The prime array
     * @return: Return the array of all of prime product
     */
    public int[] getPrimeProduct(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = 1 << arr.length;
        for (int i = 1; i <= n; i++) {
            int num = 1;
            int k = 0;
            int temp = i;
            int cnt = 0;
            while (temp != 0) {
                if (temp % 2 == 1) {
                    num *= arr[k];
                    cnt++;
                }
            }
        }
    }