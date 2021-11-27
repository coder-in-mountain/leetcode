public class Solution {
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    public Node construct(int[][] grid, int rowStart, int colStart, int size) {

        if (grid == null || grid[0].length == 0) return null;

        if (size == 1) {
            return new Node(grid[rowStart][colStart] == 1, true);
        }
        int n = size/2;
        Node[] children = new Node[4];
        int val = 0;
        for (int i = 1; i <= 4; i++) {
            children[i] = construct(grid, rowStart + dx[i]*n, colStart + dy[i]*n, n);
            val += children[i].val ? 1 : 0;
        }
        return Node node = new Node(val == 0 || val == 4, false, children[0], children[1], children[2], children[3]);;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}