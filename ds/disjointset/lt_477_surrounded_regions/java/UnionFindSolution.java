public class UnionFindSolution {

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public void surroundedRegions(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) return;
        int m = board.length, n = board[0].length, total = m * n;

        UnionFind uf = new UnionFind(total + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') continue;
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    uf.connect(i * n + j, total);
                }else{
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (board[x][y] == 'O'){
                            uf.connect(i*n + j, x*n + y);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O' && uf.find(i*n + j) != total) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class UnionFind{
    int[] parent;

    UnionFind(int n) {
        parent = new int[n];
        for (int i = 1; i < n; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void connect(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[Math.min(px, py)] = Math.max(px, py);
        }
    }
}