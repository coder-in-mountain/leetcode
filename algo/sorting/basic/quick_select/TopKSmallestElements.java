public class TopKSmallestElements {

    public int[] firstKSmallestElements(int[] A, int k) {
        int idx = selectK(A, 0, A.length - 1, k);
        return Arrays.copyOf(A, k);
    }

    int selectK(int[] A, int low, int high, int k) {
        int pivot = partition(A, low, high);
        int leftElements = pivot - left + 1;
        if (leftElements == k) {
            return pivot;
        }
        if (leftElements < k) {
            return selectK(A, pivot + 1, high, k - leftElements);
        }else{
            return selectK(A, low, pivot-1, k);
        }
    }

    int partition(int[] A, int low, int high) {
        int pivot = low + (high - low)/2;
        if (pivot != high) {
            swap(A, pivot, high);
            pivot = high;
        }
        while (low <= high) {
            if (A[low] < A[pivot]) {
                low++;
            }else if (A[high] > A[pivot]) {
                high--;
            }else{
                swap(A, low++, high--);
            }
        }
        swap(A, low, pivot);
        return low;
    }

    int selectKIterative(int[] A, int low, int high, int k) {
        int leftCnt = 0, pivot = low;
        do {
            pivot = partition(A, low, high);
            leftCnt = pivot - low + 1;
            if (leftCnt < k) {
                low = pivot + 1;
                k -= leftCnt;
            }else if (leftCnt > k) {
                high = pivot - 1;
            }
        } while (lefCnt != k);

        return pivot;
    }
}