class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        
        int n = nums.length-1;
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            
            if(nums[i+1]<nums[i]){
                
                start = Math.min(start,nums[i+1]);
                
            }
            
            
        }
        
        for(int i=n; i>0; i--){
            
            if(nums[i]<nums[i-1]){
                
                end = Math.max(end,nums[i-1]);
                
            }
            
        }
        
        
        
        
        for(int i=0; i<=n;i++){
            
            if(nums[i]>start){
                
                start = i;
                break;
                
            }
            
        }
        
        for(int i=n; i>=0;i--){
            
            if(nums[i]<end){
                
                end = i;
                break;
                
            }
            
        }
        
        if(start>end)return 0;
        
        return end - start +1;
    }
}