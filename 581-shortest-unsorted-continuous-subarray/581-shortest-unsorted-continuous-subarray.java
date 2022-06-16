class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = nums.length;
        int end = -1, begin = 0;
        
        for(int i=n-1;i>=0;i--){
            
            min = Math.min(min,nums[i]);
            if(nums[i]>min){
                begin=i;
            }
        }
        
        for(int i=0;i<n;i++){
            
            max = Math.max(max,nums[i]);
            if(nums[i]<max)
                end = i;
        }
        
        return end-begin +1;
    }
}