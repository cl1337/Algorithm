class Solution:
    def levelOrder(self, root):
        if root is None:
            return []
        current, ret = [root], []
        while current:
            next_level, vals = [], []
            for node in current:
                vals.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            ret.append(vals)
            current = next_level
        return ret

