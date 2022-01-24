public class DFSSolution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public boolean findHer(String[] maze) {
        if (maze == null || maze.length == 0 || maze[0].length() == 0) {
            return false;
        }
        int[] s = findTarget(maze, 'S');
        boolean[][] visited = new boolean[maze.length][maze[0].length()];
        return dfs(maze, s[0], s[1], visited);
    }

    boolean dfs(String[] maze, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        if (maze[x].charAt(y) == 'T') {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx >= 0 && yy >= 0 && xx < maze.length && yy < maze[0].length() && !visited[xx][yy] && maze[xx].charAt(yy) != '*') {
                if (maze[xx].charAt(yy) == 'T' || dfs(maze, xx, yy, visited))
                    return true;
            }
        }
        return false;
    }

    int[] findTarget(String[] maze, char target) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                if (maze[i].charAt(j) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        t(new String[]{
                ".***.",
                "**T..",
                "..S*.",
                ".....",
                "....."
        });
        t(new String[]{
                ".S.*.",
                "**...",
                "..*..",
                "*.*..",
                "T...."
        });
    }

    static void t(String[] maze) {
        System.out.println();
        for (String s : maze) {
            System.out.println(s);
        }
        System.out.println(new DFSSolution().findHer(maze));
    }
}