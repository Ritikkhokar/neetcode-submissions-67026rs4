class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = 0;
        int left =0;
        int right = matrix.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(target>= matrix[mid][0] && target<= matrix[mid][matrix[0].length-1]){
              rowIdx = mid;
              break;  
            }
            if(target<matrix[mid][0]){
                right = mid-1;
            }else{
                left = left +1;
            }
        }
        return checkElementInTargetRow(matrix[rowIdx], target);
    }

    public boolean checkElementInTargetRow(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(target == nums[mid]){
                return true;
            }
            if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return false;
    }
}
