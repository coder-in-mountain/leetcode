import java.util.*;
class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        String[] str = split(s);
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < str.length) {
            String v = str[i];
            if (isNumber(v)) {
                stack.push(new TreeNode(Integer.parseInt(v)));
            }else if (v.equals(")")) {
                TreeNode node = stack.pop();

                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                }else{
                    parent.right = node;
                }
            }
            i++;
        }
        return stack.isEmpty() ? null : stack.pop();
    }
    boolean isNumber(String s) {
        return Character.isDigit(s.charAt(s.length() - 1));
    }
    String[] split(String input) {

        List<String> list = new ArrayList<>();
        int i = 0, n = input.length();
        char[] chs = input.toCharArray();

        while ( i < n ) {
            if (chs[i] == '(' || chs[i] == ')') {
                list.add(String.valueOf(chs[i]));
                i++;
            }else{
                int j = i+1;
                while (j < n && chs[j] != '(' && chs[j] !=')') {
                    j++;
                }
                list.add(String.valueOf(chs, i, j - i));
                i = j;
            }
        }
        return list.toArray(new String[0]);
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