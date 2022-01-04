import java.util.*;
public class Solution {

    public int[] largestSubarray(int[] A, int K) {
        if (A == null) return new int[0];
        if (A.length == 0 || A.length < K) return A;

        int n = A.length;
        int maxIndex = 0;
        for (int i = 0; i <= n - K; i++) {
            for (int j = 0; j < K; j++) {
                if (A[i+j] > A[maxIndex + j]) {
                    maxIndex = i;
                    break;
                }else if (A[i+j] < A[maxIndex + j]){
                    break;
                }
            }
        }
        return Arrays.copyOfRange(A, maxIndex, maxIndex + K);
    }

    public static void main(String[] args) {
        t(new int[]{1,4,3,2,5}, 4);
    }

    static void t(int[] A, int K) {
        int[] B = new Solution().largestSubarray(A, K);
        System.out.println(Arrays.toString(B));
    }
}