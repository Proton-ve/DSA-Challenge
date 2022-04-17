class Solution {
    public int searchInsert(int[] nums, int target) {
        
        
        int start = 0;
        int end = nums.length-1;
        int ans = 0;
        
        if(target>nums[end])return end+1;        
        
        while(start<=end){
            
            int mid = (start+end)/2;
            
            if(target == nums[mid])
                return mid;
            else
                if(target>nums[mid])
                    start = mid+1;
            else
                if(target<nums[mid]){
                    ans = mid;
                    end = mid-1;
                }
        }
    
    return ans;
    }
}