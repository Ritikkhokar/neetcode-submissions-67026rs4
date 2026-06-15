class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    markIsland(i,j,grid, visited);
                }
            }
        }
        return count;
    }

    public static void markIsland(int i, int j,char[][] grid, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        
        visited[i][j] = true;
        // left call
        markIsland(i,j-1, grid, visited);
        // right call
        markIsland(i,j+1, grid, visited);
        // top call
        markIsland(i-1,j, grid, visited);
        // bottom call
        markIsland(i+1,j, grid, visited);
    }
}
