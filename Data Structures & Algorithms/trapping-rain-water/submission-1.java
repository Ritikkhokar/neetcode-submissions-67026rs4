class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i=height.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int water = 0;
        for(int i=0;i< height.length-1;i++){
            water += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return water;
    }
}
