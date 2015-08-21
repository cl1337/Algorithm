class Solution:
    def multiply(self, num1, num2):
        ret = ""
        if len(num1) < len(num2):
            return self.multiply(num2, num1)
        offset = 0
        for char in num2[-1::-1]:
            # multiply
            aux = 0
            tmp = ""
            for x in num1[-1::-1]:
                val = int(x) * int(char) + aux
                aux = val/10
                tmp = str(val%10) + tmp
            if aux>0:
                tmp = str(aux)+tmp
            for i in xrange(offset):
                tmp += "0"

            # add
            idx1, idx2 = len(ret) -1, len(tmp)-1
            aux = 0
            curr = ""
            while idx1 >-1 or idx2>-1:
                if idx1 > -1 and idx2 > -1:
                    val = int(ret[idx1]) + int(tmp[idx2]) + aux
                    idx1 -=1
                    idx2 -=1
                elif idx1> -1:
                    val = int(ret[idx1]) + aux
                    idx1 -= 1
                else:
                    val = int(tmp[idx2]) + aux
                    idx2 -=1
                curr = str(val%10) + curr
                aux = val/10
            if aux>0:
                curr = str(aux) + curr
            ret = curr

            offset += 1
        return ret

