import java.util.*;

/*
求流数据的中位数，仍然是一个排序问题。题目要求比较便利的方法来访问中位，合适的数据结构可以是
    基于排序的数组，对插入而言，进行O(N)的插入排序
    将数据分为两段，每段使用一个heap来维护。左侧使用最大堆，右侧使用最小堆

注意到，本题说的是data stream，但并没有提到数据的流出操作。如果加入数据流出的操作，应该如何处理？
*/

public class HeadBasedSolution {
    private Queue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // maxHeap
    private Queue<Integer> right = new PriorityQueue<>(); // minHeap

    public void addNum(int num) {
        right.add(num);
        left.add(right.poll());
        if (right.size() < left.size()) {
            right.add(left.poll());
        }
    }

    public double findMedian() {
        return right.size() > left.size() ? right.peek() : (right.peek() + left.peek())/2.0;
    }
}