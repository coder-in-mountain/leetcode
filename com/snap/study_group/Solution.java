import java.util.*;
public class Solution {
    /**
     * n schools, each school has school[i] students. Given an integer K, we want to form as much as possible study groups.

     * A group much be formed by k students coming from k different schools.
     */

    int maxGroups(int[] schools, int k) {
        if (schools.length < k) return 0;
        int i = 0, n = schools.length, groups = 0;
        Arrays.sort(schools);
        while (i + k <= n) {
            groups += schools[i];
            for (int j = 1; j < k; j++) {
                schools[i+j] -= schools[i];
            }
            i++;
        }
        return groups;
    }

    public static void main(String[] args) {
        t(new int[]{2}, 1);
        t(new int[]{1,2}, 3);
        t(new int[]{1,2}, 1);
        t(new int[]{1,2,3,4,5}, 2);

    }
    static void t(int[] schools, int k) {
        System.out.printf(
            "%s\tK = %d\t max groups = %d\n", Arrays.toString(schools), k, new Solution().maxGroups(schools, k));
    }
}