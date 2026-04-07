class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int maxArea = 0;
        while(l<r){
          maxArea = Math.max(Math.min(heights[l],heights[r])*(r-l), maxArea);
          if(heights[r]<heights[l]){
            r--;
          }else{
            l++;
          }
        }
        return maxArea;
    }
}
