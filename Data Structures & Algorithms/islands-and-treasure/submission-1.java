class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }

        // BFS on every island
        while(q.size()>0){
            int[] node = q.poll();
            // up call
            if(node[0]>0){
                if(grid[node[0]-1][node[1]] != -1 
                && grid[node[0]-1][node[1]] != 0
                && grid[node[0]-1][node[1]] > grid[node[0]][node[1]]){
                    grid[node[0]-1][node[1]] = grid[node[0]][node[1]] + 1;
                    q.add(new int[] {node[0]-1, node[1]});
                }
            }

            // down call
            if(node[0]<grid.length-1){
                if(grid[node[0]+1][node[1]] != -1 
                && grid[node[0]+1][node[1]] != 0
                && grid[node[0]+1][node[1]] > grid[node[0]][node[1]]){
                    grid[node[0]+1][node[1]] = grid[node[0]][node[1]] + 1;
                    q.add(new int[] {node[0]+1, node[1]});
                }
            }

            // left call
            if(node[1]>0){
                if(grid[node[0]][node[1]-1] != -1 
                && grid[node[0]][node[1]-1] != 0
                && grid[node[0]][node[1]-1] > grid[node[0]][node[1]]){
                    grid[node[0]][node[1]-1] = grid[node[0]][node[1]] + 1;
                    q.add(new int[] {node[0], node[1]-1});
                }
            }

            // right call
            if(node[1]<grid[0].length-1){
                if(grid[node[0]][node[1]+1] != -1 
                && grid[node[0]][node[1]+1] != 0
                && grid[node[0]][node[1]+1] > grid[node[0]][node[1]]){
                    grid[node[0]][node[1]+1] = grid[node[0]][node[1]] + 1;
                    q.add(new int[] {node[0], node[1]+1});
                }
            }


        }
        
    }
}
