class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    boolean isWordFounded = find(board, i, j, word,0, visited);
                    if(isWordFounded){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean find(char[][] board, int i, int j, String word, int idx, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }
        if(visited[i][j]){
            return false;
        }
        if(board[i][j] != word.charAt(idx)){
           return false;
        }
        if(board[i][j] == word.charAt(idx) && idx == word.length()-1){
           return true;
        }

        visited[i][j] = true;
        
        // left call
        if(j>0){
          if(find(board, i, j-1, word,idx+1, visited)){
            return true;
          }
        }
        // up call
        if(i>0){
          if(find(board, i-1, j, word,idx+1, visited)){
            return true;
          }
        }
        // right call
        if(j<board[0].length-1){
          if(find(board, i, j+1, word,idx+1, visited)){
            return true;
          }
        }
        // down call
        if(i<board.length-1){
          if(find(board, i+1, j, word,idx+1, visited)){
            return true;
          }
        }
        visited[i][j] = false;

        return false;
        
    }
}
