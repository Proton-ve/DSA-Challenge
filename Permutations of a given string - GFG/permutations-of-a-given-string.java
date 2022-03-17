// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        ArrayList<String> ans =  permutations(S,"");
        Collections.sort(ans);
        return ans;
    }
    
    public static ArrayList<String> permutations(String input, String output){
        
        
        ArrayList<String> ans = new ArrayList<String>();
        
        if(input.isEmpty()){
            ans.add(output);
            return ans;
            
        }
        
        
        
        char c = input.charAt(0);
        
        ArrayList<String> op = new ArrayList<String>();
        
        for(int i=0;i<=output.length();i++){
            
            String part1 = output.substring(0,i);
            String part2 = output.substring(i,output.length());
            
            ArrayList<String> temp = permutations(input.substring(1),part1+c+part2);
            op.addAll(temp);
            
        }
        
        
        return op;
    }
    
}