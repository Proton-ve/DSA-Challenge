//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int n){
        
        // int[] dp = new int[n];
        // solve(arr, dp, n-1);
        // return dp[n-1];
        return solveTabu(n,arr);
        
    }
    
    
    // tabulation with space opti
    public int solveTabu(int n, int[] arr){
        
        int prev=0, prevprev=0, cur=0;

        for(int i=1;i<n;i++){
            
            int left = prev+Math.abs(arr[i]-arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1)
                right = prevprev+Math.abs(arr[i]-arr[i-2]);
                
            cur = Math.min(left,right);
            prevprev = prev;
            prev = cur;
            
        }
        
        return prev;
    }
    
    
    // // tabulation
    // public int solveTabu(int n, int[] arr){
        
    //     int[] dp = new int[n];

    //     for(int i=1;i<n;i++){
            
    //         int left = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
    //         int right = Integer.MAX_VALUE;
    //         if(i>1)
    //             right = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
    //         dp[i] = Math.min(left,right);
            
    //     }
        
    //     return dp[n-1];
    // }
    
    
    // memoization
    // public int solve(int[] arr, int[] dp, int n){
        
    //     if(n<=0)
    //         return 0;

    //     if(dp[n]!=0)
    //         return dp[n];
        
    //     int left = solve(arr,dp,n-1) + Math.abs(arr[n]-arr[n-1]);
    //     int right = Integer.MAX_VALUE;
    //     if(n>1)
    //         right = solve(arr,dp,n-2) + Math.abs(arr[n]-arr[n-2]);
        
    //     dp[n] = Math.min(left,right);
        
    //     return dp[n];
    // }
    
}