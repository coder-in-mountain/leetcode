class recusionSolution:
    def str2tree(self, s: str) -> Optional[TreeNode]:
        if not s:
            return None
        def helper(node, i):
            j = i;
            while j < len(s) and s[j] not in "()":
                j += 1
            node.val = int(s[i:j])

            if s[i:] and s[i] == '(':
                node.left = TreeNode()
                j = helper(node.left, i+1)
                if s[j:] and s[j] == '(':
                    node.right = TreeNode()




class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right