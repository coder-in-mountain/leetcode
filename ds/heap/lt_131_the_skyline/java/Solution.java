import java.util.*;
public class Solution {
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;

        List<int[]> lines = new ArrayList<>();
        for (int[] b : buildings) {
            lines.add(new int[]{b[0], -b[2]}); //将左边界起点的高度设为负数, 区别左右边界
            lines.add(new int[]{b[1], b[2]});
        }
        /*
         * 排序：从左到右，当横坐标x相同，这时候有特殊情况处理：如果两个building相连，则在同一个x点，
         * 有左右两条线，我们需要先处理右边界，然后左边界。这也是我们将左边界起点的高度设为负数的原因
         */
        Collections.sort(lines, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int prevMaxHeight = 0, prevX = 0;

        for (int[] l : lines) {
            if (l[1] < 0) {
                maxHeap.offer(-l[1]);
            } else {
                maxHeap.remove(l[1]);
            }
            if (prevMaxHeight == 0) {
                prevMaxHeight = Math.abs(l[1]);
                prevX = l[0];
            } else {
                if (maxHeap.isEmpty()) {
                    res.add(Arrays.asList(prevX, l[0], prevMaxHeight);
                    prevMaxHeight == 0；
                }else if (prevMaxHeight != maxHeap.peek()) {
                    res.add(Arrays.asList(prevX, l[0], prevMaxHeight);
                    prevMaxHeight = maxHeap.peek();
                    prevX = l[0];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
            t(new int[][]{{2,9,10}, {3,7,15}, {5,12,12}, {15,20, 10}, {19, 24, 8}});
    }
    static void t(int[][] input) {
        for (int[] itv : input) {
            System.out.printf("[%d, %d, %d]\n", itv[0], itv[1], itv[2]);
        }
        System.out.println();
        List<List<Integer>> skyline = new Solution().buildingOutline(input);
        for (List<Integer> l : skyline) {
            for (Integer i : l)
                System.out.print(i + ", ");
            System.out.println();
        }
    }

}
