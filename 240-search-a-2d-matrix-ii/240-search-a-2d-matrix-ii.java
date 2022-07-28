class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length, m=matrix[0].length, i=0 ,j=m-1;
        
        while(i<n && j>=0){
            
            int cur = matrix[i][j];
            
            if(cur==target)
                return true;
            
            if(cur>target)
                j--;
            else
                i++;
            
        }
        
       return false; 
    }
}