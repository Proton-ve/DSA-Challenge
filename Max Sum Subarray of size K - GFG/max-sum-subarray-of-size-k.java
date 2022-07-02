// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int n){
        // code here
        
        int i=0,j=0;
        long ans=-1,sum=0;
        
        while(j<n){
            
            sum+=Arr.get(j);
            
            if((j-i+1)<k){
                j++;
            }
            else
                if((j-i+1)==k){
                    ans = Math.max(sum,ans);
                    sum-=Arr.get(i++);
                    j++;
                }
        }
        
        return ans;
        
        
        
        // method 1 :
        
        // int i=0;
        // long sum=0;
        
        // for(i=0;i<k;i++){
        //     sum+=Arr.get(i);
        // }
        
        // int start=0, end=i;
        // long ans=sum;
        
        // while(end<n){
            
        //     sum+=Arr.get(end++);
        //     sum-=Arr.get(start++);
        //     ans = Math.max(sum,ans);
        // }
        
        // return ans;
        
    }
}