class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i=0, j=0, sum=0;
        int n = nums.length, window=Integer.MAX_VALUE;
        boolean flag = false;
        
        while(j<n){
            
            sum+=nums[j];
            
            while(i<n && sum>=target){
                flag = true;
                window = Math.min(window, j-i+1);
                sum-=nums[i];
                i++;
            }
            
            j++;
            
        }
        
        return flag?window:0;
    }
}