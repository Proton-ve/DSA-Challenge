class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<9;i++){
            int j=0;
            HashSet<Character> nums = new HashSet(9);
            for(j=0;j<9;j++){

                char c = board[i][j];
                if(c!='.'){
                    if(nums.contains(c))
                        return false;
                    else
                        nums.add(c);
                }
            }
        }
        
        for(int i=0;i<9;i++){
            int j=0;
            HashSet<Character> nums = new HashSet(9);
            for(j=0;j<9;j++){
                char c = board[j][i];
                if(c!='.'){
                    if(nums.contains(c)){
                        return false;
                    }else
                        nums.add(c);
                }
            }
        }
        
        for(int i=0;i<9;i=i+3)
            for(int j=0;j<9;j+=3){
                HashSet<Character> nums = new HashSet(9);
                for(int r=i;r<i+3;r++)
                    for(int c=j;c<j+3;c++){
                        char b = board[r][c];
                        if(b!='.'){
                            if(nums.contains(b))
                                return false;
                            else
                                nums.add(b);
                        }
                    }
            }
                    
                 
            
        
     
        return true;
    }
}