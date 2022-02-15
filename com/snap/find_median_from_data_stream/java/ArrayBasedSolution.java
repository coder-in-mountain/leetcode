import java.util.*;

public class ArrayBasedSolution {
    ArrayList<Integer> store;

    public ArrayBasedSolution() {
        store = new ArrayList<>();
    }
    public void addNum(int num) {
        if (store.size() == 0) {
            store.add(num);
        }else {
            int index = find(store, 0, store.size() - 1, num);
            store.add(index, num);
        }
    }
    // return the index of the first element equal or larger than x
    // time complexity: binary search takes O(lgn), insertion takes O(n), so it is O(n)
    int find(ArrayList<Integer> list, int left, int right, int x) {
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (list.get(mid) <= x) {
                left = mid;
            }else{
                right = mid;
            }
        }
        if (list.get(right) <= x) {
            return right+1;
        }
        if (list.get(left) <= x) {
            return right;
        }
        return left;
    }

    // Time complexity : O(1)
    double findMedian() {
        int n = store.size();
        System.out.println(store);
        System.out.println(n/2);
        System.out.println(store.get(n/2));
        return (n % 2 == 0) ? (store.get(n/2-1) + store.get(n/2))/2 : store.get(n/2);
    }

    public static void main(String[] args) {
        ArrayBasedSolution sol = new ArrayBasedSolution();
        // Case 1
//        sol.addNum(1);
//        sol.addNum(2);
//        System.out.println(sol.findMedian());
//        sol.addNum(3);
//        System.out.println(sol.findMedian());

        // Case 2
        sol.addNum(-1);
        System.out.println(sol.findMedian());
        sol.addNum(-2);
        System.out.println(sol.findMedian());
        sol.addNum(-3);
        System.out.println(sol.findMedian());
        sol.addNum(-4);
        System.out.println(sol.findMedian());
        sol.addNum(-5);
        System.out.println(sol.findMedian());
    }
}