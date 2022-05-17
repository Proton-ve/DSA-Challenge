class Solution {
    
    static int[] nums = {1,2,3,4,5,6,7,8,9};
    
    public List<List<Integer>> combinationSum3(int k, int n) {
     
        
        
        ArrayList<List<Integer>> ans = new ArrayList();

        
        subset(k, 0, n, new ArrayList(), n, ans);
        
        
        return ans;
    }
    
    
    public static void subset(int k, int i, int n, List<Integer> out, int sum, ArrayList<List<Integer>> ans){

        
        if(i==n-1 || out.size()==k){
            

            if(sum==0 && out.size()==k){
                List<Integer> temp = new ArrayList(out);
                ans.add(temp);
                return ;
            }
                        
            return ;
        }

        if(sum<0 || i>n-1 || i>8)return;

        
        
        if(sum>0){
            
            out.add(nums[i]);            
            subset(k, i+1, n, out, sum-nums[i], ans);
            out.remove(out.size()-1);
            
        }
                    
        subset(k,i+1, n, out, sum, ans);
        return ;
    }
}