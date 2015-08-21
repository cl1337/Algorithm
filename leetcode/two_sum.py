class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        hash_table = dict()
        for idx, val in enumerate(num):
            import ipdb; ipdb.set_trace();
            if not val in hash_table:
                hash_table[val] = idx
            elif val *2 == target:
                return (hash_table[val], idx)

        for idx, val in enumerate(num):
            if target - val in hash_table:
                return (i, hashtable[x]) if i<hashtable[x] else (hashtable[x], i)


# if __name__ == "__main__":
#     obj = Solution()
#     print obj.twoSum([2,7,11,15], 9)

