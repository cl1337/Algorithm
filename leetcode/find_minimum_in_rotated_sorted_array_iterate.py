class Solution(object):
    def findMin(self, num):
        while len(num)>1:
            if num[0]<num[-1]:
                return num[0]
            mid = (len(num)-1) / 2
            if num[mid] > num[-1]:
                num = num[mid+1:]
            else:
                num = num[:mid+1]
        return  num[0]
