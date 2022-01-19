import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            nums.add(i);
        }
        nums.add(n+1);

        List<List<Integer>> output = new ArrayList<>();
        int j = 0;
        while (j < k) {
            otuput.add(new LinkedList(nums.subList(0, k)));

        }
    }
}