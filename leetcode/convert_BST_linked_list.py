class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left, self.right = None, None

if __name__ == '__main__':

    prev, head = None,None
    def convert(root):
        if not root:
            return
        convert(root.left)
        root.left = prev
        if prev:
            prev.right = root
        else:
            head = root

        tmp = root.right
        root.right = head
        head.left = root
        prev = root
        conver(tmp)

