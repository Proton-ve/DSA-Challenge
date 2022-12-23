class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int i=0, j=0, m=matrix.length, n=matrix[0].length;
        List<Integer> list = new ArrayList(m*n);
        
        while(true){

            boolean flag = false;

            while(j<n && matrix[i][j]!=-101){
                list.add(matrix[i][j]);
                matrix[i][j] = -101;
                flag = true;
                j++;
            }

            j--;
            i++;

            while(i<m && matrix[i][j]!=-101){
                list.add(matrix[i][j]);
                matrix[i][j] = -101;
                flag = true;
                i++;
            }

            i--;
            j--;

            while(j>=0 && matrix[i][j]!=-101){
                list.add(matrix[i][j]);
                matrix[i][j] = -101;
                flag = true;
                j--;
            }

            j++;
            i--;

            while(i>=0 && matrix[i][j]!=-101){
                list.add(matrix[i][j]);
                matrix[i][j] = -101;
                flag = true;
                i--;
            }

            i++;
            j++;

            if(!flag)break;

        }
        
        return list;
    }
}