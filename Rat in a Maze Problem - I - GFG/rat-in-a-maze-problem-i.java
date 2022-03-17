// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        boolean[][] marks = new boolean[n][n];
        
        return maze(m,n,"",0,0, marks);
        
        
        
        
    }
    
    
    public static ArrayList<String> maze(int[][] m, int n, String out, int i, int j, boolean[][] marks){
        
        ArrayList<String> ans = new ArrayList<String>();
        
        if(i>n-1 || j >n-1 || i<0 || j<0 || marks[i][j]==true)return ans;
        
        if(m[i][j]==0)return ans;
        

        if(i==n-1 && j==n-1 ){
            
            ans.add(out);
            return ans;
        }
        
        marks[i][j] = true;
        
        ArrayList<String> a  = maze(m,n,out+'D',i+1,j, marks);
        ArrayList<String> b  = maze(m,n,out+'L',i,j-1, marks);
        ArrayList<String> c  = maze(m,n,out+'U',i-1,j, marks);
        ArrayList<String> d  = maze(m,n,out+'R',i,j+1, marks);
        
        marks[i][j] = false;
        
        a.addAll(b);
        a.addAll(c);
        a.addAll(d);


        return a;
        
    }
    
    
}