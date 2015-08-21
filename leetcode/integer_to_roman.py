class Solution:
    def intToRoman(self, num):
        chars = ['M','CM','D','CD','C','XC','L','XL','X','IX','V','IV','I']
        digits = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
        curr = 0
        ret = ""
        while num>0:
            if num >= digits[curr]:
                num -= digits[curr]
                ret += chars[curr]
            else:
                curr += 1
        return ret

