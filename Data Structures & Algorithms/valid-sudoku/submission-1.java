class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row check
        for(int i=0;i<board.length;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if (board[i][j] == '.') continue;
                if(set.contains(board[i][j])){
                    return false;
                }else{
                    set.add(board[i][j]);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if (board[j][i] == '.') continue;
                if(set.contains(board[j][i])){
                    return false;
                }else{
                    set.add(board[j][i]);
                }
            }
        }

        for(int i=0;i<9;i = i+3){
            for(int j=0;j<9;j = j+3){
                Set<Character> set = new HashSet<>();
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if (board[k][l] == '.') continue;
                        if(set.contains(board[k][l])){
                            return false;
                        }else{
                            set.add(board[k][l]);
                        } 
                    }
                }
            }
        }

        return true;
    }
}
