class Ocean{
    boolean pacific;
    boolean atlantic;
}

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ans = new ArrayList<>();
        Ocean[][] ocean = new Ocean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                ocean[i][j] = new Ocean();
            }
        }
        for (int j = 0; j < heights[0].length; j++) {
            pacific(heights, 0, j, ocean);                       // top row
            atlantic(heights, heights.length-1, j, ocean);       // bottom row
        }
        for (int i = 0; i < heights.length; i++) {
            pacific(heights, i, 0, ocean);                       // left col
            atlantic(heights, i, heights[0].length-1, ocean);    // right col
        }

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(ocean[i][j].pacific && ocean[i][j].atlantic){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    ans.add(arr);
                } 
            }
        }

        return ans;
    }
    
    




    public void pacific(int[][] heights, int i, int j, Ocean[][] ocean){
        // base case
        // pacific check
        if(ocean[i][j].pacific){
           return;
        }
        ocean[i][j].pacific = true;

        // up call
        if(i>0 && heights[i-1][j]>=heights[i][j]){
           pacific(heights, i-1,j, ocean); 
        }
        // down call
        if(i<heights.length-1 && heights[i+1][j]>=heights[i][j]){
           pacific(heights, i+1,j, ocean); 
        }
        // left call
        if(j>0 && heights[i][j-1]>=heights[i][j]){
           pacific(heights, i,j-1, ocean); 
        }
        // right call
        if(j<heights[0].length-1 && heights[i][j+1]>=heights[i][j]){
           pacific(heights, i,j+1, ocean); 
        }
    }

    public void atlantic(int[][] heights, int i, int j, Ocean[][] ocean){
        // base case
        // atlantic check
        if(ocean[i][j].atlantic){
           return;
        }
        ocean[i][j].atlantic = true;

        // up call
        if(i>0 && heights[i-1][j]>=heights[i][j]){
           atlantic(heights, i-1,j, ocean); 
        }
        // down call
        if(i<heights.length-1 && heights[i+1][j]>=heights[i][j]){
           atlantic(heights, i+1,j, ocean); 
        }
        // left call
        if(j>0 && heights[i][j-1]>=heights[i][j]){
           atlantic(heights, i,j-1, ocean); 
        }
        // right call
        if(j<heights[0].length-1 && heights[i][j+1]>=heights[i][j]){
           atlantic(heights, i,j+1, ocean); 
        }
    }
}
