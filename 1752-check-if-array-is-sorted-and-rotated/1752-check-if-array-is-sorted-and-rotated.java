class Solution {
    public boolean check(int[] nums) {
        
        int n=nums.length;
        int first=nums[0], peek=0;
        
        int i=0;
        
        while(i<n-1){
            
            if(nums[i+1]<nums[i]){
                peek = nums[i];
                break;
            }
            i++;
        }
        
        i++;
        
        while(i<n){

            if(nums[i]>first || nums[i]>peek){
                return false;
            }
            
            if(i<n-1){
                if(nums[i]>nums[i+1])return false;
            }
            
            i++;
        }
        
        return i>=n-1;
        
        
    }
}