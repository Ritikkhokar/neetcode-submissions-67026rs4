class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxAreea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxAreea = Math.max(calculateArea(i,j,grid, visited, 0), maxAreea);
                }
            }
        }
        return maxAreea;
    }

    public static int calculateArea(int i, int j,int[][] grid, boolean[][] visited, int area){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j] || grid[i][j] == 0){
            return 0;
        }
        
        visited[i][j] = true;
        
        // left call
        area = calculateArea(i,j-1, grid, visited, area)
               + calculateArea(i,j+1, grid, visited, area)
               + calculateArea(i-1,j, grid, visited, area)
               + calculateArea(i+1,j, grid, visited, area);
        
        return area +1;
    }
}
