import java.util.*;

public class Solution {
    public int maxProfit(int[] arr) {
        if (arr == null || arr.length < 2) return 0;

        PriorityQueue<Integer> miHeap = new PriorityQueue<>();
        int profit = 0;
        for (int i : arr) {
            if (!minHeap.isEmpty() && i > minHeap.peek()) {
                profit += i - minHeap.poll(); // make sure we accumulate the each tx profit
                /*
                 * why push the current price i twice?
                 * An easy explanation is poll operation is a buy and push is a sell.
                 * we do buy and sell at the same day so we can accumulate the profit for future higher prices.
                 *
                 */
                minHeap.offer(i);
            }
            minHeap.offer(i);
        }
        return profit;
    }
}