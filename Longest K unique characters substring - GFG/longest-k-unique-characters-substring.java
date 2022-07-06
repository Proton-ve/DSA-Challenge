// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character,Integer> map = new HashMap();
        int i=0,j=0,n=s.length(),ans=-1,uniques=0;

        while(j<n){
            
            char fast = s.charAt(j);
            
            int a = map.getOrDefault(s.charAt(j),0)+1;
            map.put(fast, a);
            
            if(map.get(fast)==1)uniques++;
            
            if(uniques>k){
                
                while(i<j&&uniques>k){
                    char slow = s.charAt(i);
                    map.put(slow, map.get(slow)-1);
                    if(map.get(slow)==0){
                        map.remove(slow);
                        uniques--;
                    }
                    i++;
                }
                // j++;
            }
            
            if(uniques==k){
                ans = Math.max(ans,j-i+1);
            }
            
            j++;
        }
        
     return ans;   
    }
}