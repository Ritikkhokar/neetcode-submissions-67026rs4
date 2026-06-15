class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        nQueen(new ArrayList<>(), 0, n);
        return ans;
    }

    public void nQueen(List<String> list, int row, int n){
        if(row == n){
            ans.add(new ArrayList(list));
            return;
        }
        // ArrayList<String> line = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isSafe(list, i, row, n)){
                String qRow = "";
                for(int j=0;j<n;j++){
                   if(j==i){
                     qRow += "Q";
                   }else{
                     qRow += ".";
                   }
                }
               list.add(qRow);
               nQueen(list, row+1, n);
               list.remove(list.size()-1);
            }
            
        }
        
    }

    public static boolean isSafe(List<String> temp, int col , int row,int n )
         {
             for(int i=row-1;i>=0;i--)
             {
                 if(temp.get(i).charAt(col) == 'Q' )
                 {
                     return false;
                 }
             }
             for(int i=row-1, j =col-1;i>=0 && j>=0;i--,j--)
             {
                 if(temp.get(i).charAt(j) == 'Q' )
                 {
                     return false;
                 }
             }
             for(int i=row-1, j =col+1;i>=0 && j<n;i--,j++)
             {
                 if(temp.get(i).charAt(j) == 'Q' )
                 {
                     return false;
                 }
             }
             return true;
             
         }
        
}
