class Solution {
    public int search(int[] nums, int target) {
        
        
        int start = 0, end = nums.length-1;
        int mid = 0;
        
        while(start<=end){
            
            mid = start + (end-start)/2;
            
            if(target==nums[mid])return mid;
            
            
            // if left part of mid is unsorted
            if(nums[start]>nums[mid]){
                                
                // if(target>=nums[start] && target<nums[mid])end = mid-1;     
                // else
                if(target>nums[mid] && target<=nums[end])start = mid+1;
                else
                end = mid-1;        // if target lies in unsorted part, i.e, arr = [11,13,15,22,23,1,4,8], mid = 22, target = 4
                
            }else{      // if right part is unsorted or both parts are sorted
                
                if(target>=nums[start] && target<nums[mid])end = mid-1;
                else
                start = mid+1;   // if target lies in unsorted part
            }
            
        }
        
        return -1;
        
    }
}