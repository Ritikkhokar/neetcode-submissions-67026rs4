class Solution {
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
         
        leftMaxArr[0] = height[0]; 
        rightMaxArr[height.length-1] = height[height.length-1];

        for(int i=1;i<height.length;i++){
           if(height[i]>leftMaxArr[i-1]){
            leftMaxArr[i] = height[i];
           }else{
            leftMaxArr[i] = leftMaxArr[i-1];
           }
        }

        for(int i=height.length-2;i>=0;i--){
           if(height[i]>rightMaxArr[i+1]){
            rightMaxArr[i] = height[i];
           }else{
            rightMaxArr[i] = rightMaxArr[i+1];
           }
        }

        int totalWater = 0;
        for(int i=1;i<height.length-1;i++ ){
            if(leftMaxArr[i]<=height[i] || rightMaxArr[i]<=height[i]){
                continue;
            }else{
               totalWater += (Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i]) * 1;
            }
        }
        return totalWater;
    }
}
