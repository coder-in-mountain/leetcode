public class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int ShortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;

        Queue<int[]> queue = new LinkedList<>();
        /*
         * mark one island as -1 so we know which one is which one
         * Meanwhile, we want to add all borders of this island into queue
         */
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    break;
                }
            }
            if (!queue.isEmpty())
                break;
        }

        int step = 0;
        while (!queue.isEmpty()) {

            int n = queue.size(); // BFS, step will be increased for each expansion
            while (n-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p[0] + dx[i];
                    int y = p[1] + dy[i];
                    if (x >= 0 && y >= 0 && x < A.length && y < A[0].length ) {
                        if (A[x][y] == 1) {
                            return step;
                        }else if (A[x][y] == 0) {
                            A[x][y] = -1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
    void dfs(int[][] A, int x, int y, Queue<int[]> queue) {
        A[x][y] = -1;
        queue.offer(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < A.length && yy < A[0].length && A[xx][yy] == 1) {
                dfs(A, xx, yy, queue);
            }
        }
    }

}