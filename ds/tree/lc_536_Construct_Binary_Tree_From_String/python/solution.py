class solution:
    def str2tree(self, s: str) -> Optional[TreeNode]:
        if not s:
            return None
        n = len(s)
        i = 0

        while i < n and s[i] != '(':
            i += 1
        stack = [TreeNode(int(s[0:i]))]

        while i < n:
            if s[i] == '(':
                j = i+1
                while s[j] not in "()":
                    j += 1
                parent = stack[-1]
                node = TreeNode(int(s[i+1:j]))
                if parent.left:
                    parent.right = node
                else:
                    parent.left = node
                stack.append(node);
                i = j
            elif s[i] == ')':
                stack.pop()
                i += 1
        return stack[0]


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right