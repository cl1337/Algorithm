if __name__ == '__main__':
    def isMul(s):
        patten_pos = 0
        patten_end = 0

        for i in xrange(1,len(s)):
            if s[i] != s[patten_pos]:
                patten_pos = 0
                patten_end = i
            else:
                patten_pos += 1
                if patten_pos > patten_end and i !=len(s)-1:
                    patten_pos = 0
        return patten_pos > patten_end and patten_end > 0


    print isMul('abcabc')
