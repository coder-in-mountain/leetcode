public class RecursionSolution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) != '(') {
            i++;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s.substring(0, i)));

        if (i < n && s.charAt(i) == '(') {
            int j = getNextNodePosition(s, i);
            node.left = str2tree(s.substring(i+1, j-1));
            i = j;
        }
        if (i < n && s.charAt(i) == '(') {
            int j = getNextNodePosition(s, i);
            node.right = str2tree(s.substring(i+1, j-1));
        }
        return node;
    }

    int getNextNodePosition(String s, int i) {
        int j = i+1;
        int count = 1;
        while (j < n && count > 0) {
            char ch = s.charAt(j);
            if (ch == '(') {
                count++;
            }else if (ch == ')') {
                count--;
            }
            j++;
        }
        return j;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}