class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n=nums.length, s=0, e = n-1;
        int[] ans = new int[2];
        
        while(s<e){
            
            int sum = nums[s]+nums[e];
            
            if(sum==target){
                ans[0]=s+1;
                ans[1]=e+1;
                break;
            }
            
            if(sum>target)
                e--;
            else
                s++;
            
        }
        
        return ans;
    }
}