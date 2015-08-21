class Solution:
    def lengthOfLongestSubstring(self,in_str):
        curr = []
        ret = 0
        has = set()
        for each_char in in_str:
            if each_char not in has:
                curr.append(each_char)
                has.add(each_char)
            else:
                ret = max(ret, len(curr))
                x = curr.pop(0)
                while x != each_char:
                    has.remove(x)
                    x = curr.pop(0)
                curr.append(each_char)
        return max(ret, len(curr))
