class Solution:
    def maxArea(self,height):
        ret = 0
        l,r = 0, len(height)-1
        while l<r:
            ret = max(ret, (r-l)*min(height[l],height[r]))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return ret
