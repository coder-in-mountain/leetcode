import java.util.*;
public class Solution {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        return Math.max(licLeftToRight(A), licRightToLeft(A));
    }

    int licLeftToRight(int[] A) {
        int i = 1, n = A.length;
        int lic = 1, current = 1;
        while ( i < n ) {
            if (A[i] > A[i-1]) {
                current++;
            }else{
                lic = Math.max(lic, current);
                current = 1;
            }
            i++;
        }
        lic = Math.max(lic, current);
        return lic;
    }

    int licRightToLeft(int[] A) {
        int n = A.length;
        int i = n-2, lic = 1;
        int current = 1;
        while (i >= 0) {
            if (A[i] > A[i+1]) {
                current++;
            }else{
                lic = Math.max(lic, current);
                current = 1;
            }
            lic = Math.max(lic, current);
            i--;
        }
        return lic;
    }
}