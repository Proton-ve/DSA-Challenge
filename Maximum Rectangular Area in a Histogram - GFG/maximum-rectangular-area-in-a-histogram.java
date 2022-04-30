// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long heights[], long n) 
    {
        // your code here
        int[] prevSmallers = previousSmaller(heights);
        int[] nextSmallers = nextSmaller(heights);
                
        long maxArea = 0;
        
        for(int i=0;i<n;i++){
            
            long currArea = (nextSmallers[i] - prevSmallers[i]-1)*heights[i];
            
            if(currArea>maxArea)maxArea = currArea;
                    
        }
                
        return maxArea;
        
    }
    
    
    public static int[] previousSmaller(long[] arr){
        
        int n = arr.length;
        int[] ans = new int[n];
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n;i++){

            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();

            ans[i] = stack.isEmpty() ? -1:stack.peek();

            stack.push(i);

        }
     
        return ans;
    }
    
    
    public static int[] nextSmaller(long[] arr){
        
        int n = arr.length;
        int[] ans = new int[n];
        
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){

            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();

            ans[i] = stack.isEmpty() ? n:stack.peek();

            stack.push(i);


        }
        
        return ans;
    }
        
}



