class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O'){
                updatingEdgeRegions(board, 0, i); 
            }
            if(board[board.length-1][i] == 'O'){
                updatingEdgeRegions(board, board.length-1, i);
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O'){
                updatingEdgeRegions(board, i, 0);
            }
            if(board[i][board[0].length-1] == 'O'){
                updatingEdgeRegions(board, i, board[0].length-1);
            }
            
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O'){
                   board[i][j] = 'X';
                }else if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    public void updatingEdgeRegions(char[][] board, int i, int j){
        
        board[i][j] = 'Y';

        // up call
        if(i>0 && board[i-1][j] == 'O'){
           updatingEdgeRegions(board, i-1,j); 
        }
        // down call
        if(i<board.length-1 && board[i+1][j] == 'O'){
           updatingEdgeRegions(board, i+1,j); 
        }
        // left call
        if(j>0 && board[i][j-1] == 'O'){
           updatingEdgeRegions(board, i,j-1); 
        }
        // right call
        if(j<board[0].length-1 && board[i][j+1] == 'O'){
           updatingEdgeRegions(board, i,j+1); 
        }
    }
}
