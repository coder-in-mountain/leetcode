import java.util.*;
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int ShortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;

        int m = A.length, n = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int k = queue.size();
            while (k-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p[0] + dx[i];
                    int y = p[1] + dy[i];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
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

    void dfs(int[][] A, int i, int j, Queue<int[]> queue) {
        A[i][j] = -1;
        queue.offer(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] == 1) {
                dfs(A, x, y, queue);
            }
        }
    }
}