class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0,0});
        // visited[0][0] = true;
        int t = grid[0][0];
        while(pq.size()>0){
            int[] box = pq.poll();
            t = Math.max(t, box[0]);
            if(box[1] == grid.length-1 && box[2] == grid[0].length-1){
                break;
            }
            visited[box[1]][box[2]] = true;
            
            // up call
            if(box[1]>0 && !visited[box[1]-1][box[2]]){
                pq.offer(new int[]{grid[box[1]-1][box[2]], box[1]-1, box[2]});
            }
            // down call
            if(box[1]<grid.length-1 && !visited[box[1]+1][box[2]]){
                pq.offer(new int[]{grid[box[1]+1][box[2]], box[1]+1, box[2]});
            }
            // left call
            if(box[2]>0 && !visited[box[1]][box[2]-1]){
                pq.offer(new int[]{grid[box[1]][box[2]-1], box[1], box[2]-1});
            }
            // right call
            if(box[2]<grid[0].length-1 && !visited[box[1]][box[2]+1]){
                pq.offer(new int[]{grid[box[1]][box[2]+1], box[1], box[2]+1});
            }

        }
        return t;



    }
}