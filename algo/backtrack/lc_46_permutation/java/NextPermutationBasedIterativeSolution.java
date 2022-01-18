import java.util.*;
public class NextPermutationBasedIterativeSolution {

    public List<List<Integer>> perm(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;

        int n = nums.length;
        int max = factorial(n);
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        Arrays.sort(nums);
        while (s-- > 0) {
            int i = n-2;
            while (i >= 0 && nums[i] > nums[i+1]) { // 从后往前找到第一个比它右边的元素小的数
                i--;
            }
            if (i >= 0) { //从后往前找第一个比nums[i] 大的数
                int j = n-1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(num, i+1, n-1);
            List<Integer> list = new ArrayList<>();
            for (int e : nums) {
                list.add(e);
            }
            res.add(list);
        }
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
    static int factorial(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++)
            sum *= i;
        return sum;
    }
}