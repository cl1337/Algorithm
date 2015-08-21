class Solution:
    # @return a string
    def longestPalindrome(self, s):
        ret = ""
        for i in xrange(len(s)):
            l,r = i,i
            while l>=0 and r<len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            if r-l-1 > len(ret):
                ret = s[l+1:r]

            l,r = i,i+1
            while l>=0 and r<len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            if r-l-1 > len(ret):
                ret = s[l+1:r]
        return ret
