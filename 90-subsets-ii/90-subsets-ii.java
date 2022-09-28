class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        helper(nums,0,nums.length,new ArrayList(),ans);
        return ans;
        
    }

    public void helper(int[] nums, int s, int n,List<Integer> out, List<List<Integer>> subsets){
        
        subsets.add(new ArrayList(out));
        
        for(int i=s;i<n;i++){
            if(i>s && nums[i]==nums[i-1])
                continue;
            out.add(nums[i]);
            helper(nums,i+1,n,out,subsets);
            out.remove(out.size()-1);
        }
    }

}