class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(find(new boolean[board.length][board[0].length], board, word, 0, i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(boolean[][] visited, char[][] board, String word, int idx, int x, int y){
      if(idx == word.length()){
        return true;
      }
       if(board[x][y] == word.charAt(idx) && idx == word.length()-1){
           return true;
        }

      if(word.charAt(idx) == board[x][y]){
        visited[x][y] = true;
        boolean result = false;
        // left call 
         if(y>0 && visited[x][y-1] == false){
           if(find(visited, board, word, idx +1, x, y-1)){
            return true;
           }
         }
        // right call
         if(y<board[0].length-1 && visited[x][y+1] == false){
            if(find(visited, board, word, idx +1, x, y+1)){
            return true;
           }
         }
        // up call
         if(x>0 && visited[x-1][y] == false){
            if(find(visited, board, word, idx +1, x-1, y)){
            return true;
           }
         }
        //  down call
         if(x<board.length-1 && visited[x+1][y] == false){
            if(find(visited, board, word, idx +1, x+1, y)){
            return true;
           }
         }
         visited[x][y] = false;
         return false;

      }else{
        return false;
      }
    }
}
