class Solution:
# @param s, a string
# @return an integer
    def __init__(self):
        self.hashed = dict()

    def numDecodings(self, s):
        if not s or s[0] == '0':
            return 0
        if len(s)<2:
            return 1
        elif s in self.hashed:
            return self.hashed[s]
        else:
            num = int(s[0:2])
            if num>26:
                val =  self.numDecodings(s[1:])
            else:
                res1 = 1  if len(s) ==2 else self.numDecodings(s[2:])
                val = res1 + self.numDecodings(s[1:])
            self.hashed[s] = val
            return val