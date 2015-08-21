class Solution(object):
    def findMin(self, num):
        if len(num) < 2:
            return num[0]
        if num[0] < num[-1]:
            return num[0]
        else:
            mid = (len(num)-1)/2
            if num[mid] > num[-1]:
                return self.findMin(num[mid+1:])
            else:
                return self.findMin(num[:mid+1])
