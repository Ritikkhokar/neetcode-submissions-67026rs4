class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = dict();
        for i in nums:
            map[i] = map.get(i,0) + 1
        
        ans = [[] for _ in range(len(nums)+1)]
        for val, freq in map.items():
           ans[freq].append(val)
        
        finalAns = [];
        for i in range(len(ans) -1, 0, -1):
            for bucket in ans[i]:
                finalAns.append(bucket)
                if(len(finalAns) == k):
                    return finalAns;
        
        return finalAns


