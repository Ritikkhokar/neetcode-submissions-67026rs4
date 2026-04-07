class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int rowLen = matrix[0].length;
        int r = matrix.length*rowLen-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            int midRow = mid/rowLen;
            if(target>matrix[midRow][(mid)%rowLen]){
               if(target<= matrix[midRow][rowLen-1]){
                  return checkinParticularRow(matrix[midRow], (mid)%rowLen +1, rowLen-1, target);
               }else{
                  l = mid+1;
               }
            }else if(target<matrix[midRow][(mid)%rowLen]){
               if(target>= matrix[midRow][0]){
                  return checkinParticularRow(matrix[midRow], 0, (mid)%rowLen-1, target);
               }else{
                  r = mid-1;
               }
            }else{
                return true;
            }
        }
        return false;
    }

    public static boolean checkinParticularRow(int[] nums, int l, int r, int target) {
        while(l<=r){
            int mid = (l+r)/2;
            if(target<nums[mid]){
               r = mid-1;
            }else if(target>nums[mid]){
               l = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
