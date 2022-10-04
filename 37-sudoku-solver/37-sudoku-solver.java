class Solution {
    public void solveSudoku(char[][] board) {
        
        solver(board, 0, 0);
        
    }
    
    public boolean solver(char[][] board, int r, int c){
        
        int k=r, l=c;
        int[] cell = findNextEmptyCell(board, r, c);
        r = cell[0];
        c = cell[1];
        // System.out.println("for input rc"+k+" "+l+"  rc is "+r+" "+c);
        
        if(r==-1 && c == -1){
            // displayBoard(board);
            return true;
        }
        
        for(int i=1;i<=9;i++){
            
            if(isSafe(r,c,(char)(i+'0'),board)){
                
                board[r][c] = (char)(i+'0');
                
                if(solver(board,r,c))
                    return true;
                    
                board[r][c] = '.';
                
            }
        }
        
        return false;   
    }
    
    public boolean isSafe(int r, int c, char num, char[][]board){
        
        for(int i=0;i<9;i++){
            if(board[r][i]==num || board[i][c]==num){
                return false;
            }
        }
        
        int i=0, j=0;
        
        if(r<9)
            i=6;
        if(r<6)
            i=3;
        if(r<3)
            i=0;
        
        if(c<9)
            j=6;
        if(c<6)
            j=3;
        if(c<3)
            j=0;
        
        for(int p=i;p<i+3;p++){
            for(int q=j;q<j+3;q++){
                if(board[p][q]==num)
                    return false;
            }
        }
        
        return true;
    }
    
    public int[] findNextEmptyCell(char[][] board, int r, int c){
        
        int[] cell = new int[2];
        cell[0] = -1;
        cell[1] = -1;
        
        for(int i=r;i<9;i++){
            for(int j=c;j<9;j++){
                
                if(board[i][j]=='.'){
                    cell[0] = i;
                    cell[1] = j;
                    return cell;
                }
                c=0;
            }
        }
        return cell;
    }
    
    public void displayBoard(char[][] board){
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
}