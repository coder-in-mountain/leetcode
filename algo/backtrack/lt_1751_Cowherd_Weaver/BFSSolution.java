public class BFSSolution {

    public boolean findHer(String[] maze) {
        if (maze == null || maze.length == 0 || maze[0].length() == 0) return false;

        int m = maze.length, n = maze[0].length();

        int[] s = findTarget('S');

    }

    int[] findTarget(String[] maze, char ch) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                if (maze[i].charAt(j) == 'S') {
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }
}