class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
//         swap rows
        
        for(int i=0;i<n/2;i++){
            int[] temp = matrix[n-i-1];
            matrix[n-i-1] = matrix[i];
            matrix[i] = temp;
        }
        
//         Transpose
        
        int j=0;
        
        for(int r=0;r<n;r++){
            for(int c=j;c<n;c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
            j++;
        }
        
        
    }
}