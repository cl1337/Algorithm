class Solution:
    def getIntersectionNode(self, headA, headB):
        p1, p2  = headA, headB
        m, n = 0, 0
        while p1:
            p1 = p1.next
            m += 1

        while p2:
            p2 = p2.next
            n += 1

        if p1 != p2:
            return null

        p1, p2 = headA, headB
        if m >n:
            for i in xrange(m-n):
                p1 = p1.next
        else:
            for i in xrange(n-m):
                p2 = p2.next

        while p1 != p2:
            p1 = p1.next
            p2 = p2.next
        return pa

