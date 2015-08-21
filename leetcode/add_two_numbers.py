class Solution:
        # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        aux = 0
        ret = ListNode(-1)
        ret_val = ret

        while l1 or l2:
            val = 0
            if l1 and l2:
                val = aux + l1.val + l2.val
                l1 = l1.next
                l2 = l2.next
            elif l1:
                val = aux + l1.val
                l1 = l1.next
            else:
                val = aux + l2.val
                l2 = l2.next

            ret.next = ListNode(val%10)
            ret = ret.next
            aux = val/10

        if aux >0:
            ret.next = ListNode(aux)
            ret = ret.next
        return ret_val.next


