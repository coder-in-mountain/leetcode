public class Solution {
    public long playGames(int[] A) {
        long answer = 0, left = 0, right = 0; int n = a.length;

        for (int i = 0; i < n; i++) {
            if (A[i] > left) {
                left = A[i];
            }
            right += A[i];
        }

        while (left <= right) {
            long mid = left + (right - left) /2;
            if (getAns(mid, A)) {
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }

    public boolean getAns(long mid, int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += mid - A[i];
        }
        return sum >= mid ? true : false;
    }
}