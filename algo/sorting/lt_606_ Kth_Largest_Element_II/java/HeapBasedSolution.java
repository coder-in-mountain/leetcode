public class HeapBasedSolution {
    /*
     O(n) best case, O(N^2) worst case
     */
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> heap = new PriorityQueue<>(); //minHeap
        for (int i : nums) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}