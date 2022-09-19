class Solution {
    public int findMin(int[] nums) {
         
        if(nums[0]<nums[nums.length-1])
            return nums[0];
        
        int n = nums.length,
            s = 0,
            e = n-1;
        
        while(s<=e){
            
            int mid = s + (e-s)/2;
            
            if(nums[mid]<nums[e])
                e = mid;
            else if(nums[mid]>nums[e])
                s = mid+1;
            else
                e--;
            
        }
        
        return nums[s];
        
    }
}
