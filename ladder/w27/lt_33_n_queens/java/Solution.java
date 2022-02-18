public class Solution {

    public List<List<String>> nqueen(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(grid[i], '.');
        backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>(),grid, solutions);
        return solutions;
    }

    void backtrack(int row, int n, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] grid, List<List<String>> solutions) {
        if (row == n) {
            solution.add(createBoard(grid));
            return;
        }

        for (int col = 0; col < n; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            grid[row][col] = 'Q';
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            backtrack(row + 1, n, diagonals, antiDiagonals, cols, grid, solutions);

            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            grid[row][col] = '.';
        }
    }

    List<String> createBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board)
            list.add(new String(row));
        return list;
    }
}