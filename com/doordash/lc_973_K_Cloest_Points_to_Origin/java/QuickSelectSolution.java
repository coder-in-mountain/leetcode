import java.util.*;
/*
 Time Complexity: O(N) on average. O(N^2) for worst case where the worst pivot is chosen each time.
 Space Complexity: O(1) if we don't count the recursion space
 */
public class QuickSelectSolution {

    public int[][] kCloest(int[][] points, int k) {
        if (points == null || points.length <= k) return points;
        return quickselect(points, 0, points.length - 1, k);
    }

    int[][] quickselect(int[][] arr, int low, int high, int k) {
        int pivot = partition(arr, low, high);
        System.out.println("pivot = " + pivot);
        prt(arr);
        int leftCount = pivot - low + 1;

        if (leftCount == k) {
            return Arrays.copyOfRange(arr, 0, pivot+1);
        }
        if (leftCount < k) {
            return quickselect(arr, pivot + 1, high, k - leftCount);
        }else{
            return quickselect(arr, low, pivot - 1, k);
        }
    }

    int partition(int[][] points, int low, int high) {
        int pivot = low + (high - low)/2;
        if (pivot != high) {
            swap(points, pivot, high);
            pivot = high--;
        }
        int dist = distance(points[pivot]);
        while (low <= high) {
            int da = distance(points[low]);
            int db = distance(points[high]);
            if (da < dist) {
                low++;
            }else if (db >= dist) {
                high--;
            }else{
                swap(points, low++, high);
            }
        }
        swap(points, pivot, low);
        return low;
    }

    int distance(int[] p1) {
        return p1[0] * p1[0] + p1[1]*p1[1];
    }
    void swap(int[][] A, int i, int j) {
        int[] tmp = A[i]; A[i] = A[j]; A[j] = tmp;
    }

    public static void main(String[] args) {
        t(new int[][]{
                {3, 3}, {5, -1}, {-2, 4}
        }, 2);
    }

    static void t(int[][] points, int k) {

        prt(points);
        System.out.println(" K = " + k);
        int[][] klist = new QuickSelectSolution().kCloest(points, k);
        prt(klist);
    }

    static void prt(int[][] points) {
        for (int[] p : points) {
            System.out.println(Arrays.toString(p));
        }
        System.out.println();
    }
}