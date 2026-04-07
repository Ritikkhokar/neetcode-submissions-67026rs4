class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length-1;

        while(left<right){
            int tempLength = right-left;
            if(tempLength*Math.min(heights[left], heights[right])>maxWater){
                maxWater = tempLength*Math.min(heights[left], heights[right]);
            }
            if(heights[left]<heights[right]){
                left++;
            }else if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return maxWater;
    }
}
