class Solution {
    public List<List<String>> solveNQueens(int n) {
     
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList();
        placeQueen(n,0,board, ans);
        
        return ans;
    }
    
    
    public boolean isSafe(int r, int c,int n, int[][] board){
       
        // display bord
        // for(int p=0;p<n;p++){
        //     for(int q=0;q<n;q++){
        //         System.out.print(board[p][q]+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int i=0;i<r;i++){
            if(board[i][c]==1)
                return false;
        }
        
        int i=r, j=c;
        
        while(i>=0 && j<n){
            if(board[i--][j++]==1)
                return false;
        }
        
        while(r>=0 && c>=0){
            if(board[r--][c--]==1)
                return false;
        }
        return true;
    }
    
    public void placeQueen(int n, int row, int[][]board, List<List<String>> ans){
        
        if(row == n){
            ans.add(getBoard(board,n));
            return;
        }
        
        for(int col=0;col<n;col++){
            if(isSafe(row, col, n, board)){
                // System.out.println("safe rc is "+row+" "+col);
                // mark
                board[row][col] = 1;
                placeQueen(n, row+1, board, ans);
                // unmark
                board[row][col] = 0;
            }
        }
                
    }
    
    public List<String> getBoard(int[][] board, int n){
        
        List<String> a = new ArrayList();
        
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(board[i][j]==1?'Q':'.');
            }
            a.add(sb.toString());
        }
       return a; 
    }
    
    
}