class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ans = [0] * len(nums)
        left = [1] * len(nums)
        left[0] = nums[0];
        right = [1] * len(nums)
        right[len(nums)-1] = nums[len(nums)-1]
        
        for i in range( 1,len(nums),1):
            left[i] = left[i-1] * nums[i]
        
        for i in range(len(nums) -2,-1,-1):
            right[i] = right[i+1]* nums[i]
        
        print(left)
        print(right)
        
        for i in range(0,len(ans)):
            if i == 0:
                ans[i] = right[1]
            elif i == len(nums)-1:
                ans[i] = left[len(nums)-2]
            else:
                ans[i] = left[i-1] * right[i+1]
        return ans
