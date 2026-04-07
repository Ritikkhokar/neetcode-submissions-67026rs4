class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
 
        int left = 0;
        int right = (matrix.length*matrix[0].length)-1;
        while(left<=right){
            int mid = (left + right)/2;
            int val = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(target < val){
              right = mid -1;
            }else if(target > val){
              left = mid +1;
            }else{
                return true;
            }
        }
        return false;


    }
}
