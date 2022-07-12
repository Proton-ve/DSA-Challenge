class Solution {
    public int[] searchRange(int[] nums, int target) {
     
        
        int start = searchTarget(nums, target, true);
        int end = searchTarget(nums, target, false);

        int[] arr = {start,end};

        
        return arr;
    }
    
    public int searchTarget(int[] nums, int target, boolean findStartElement){
        
        int start = 0;
        int end = nums.length-1;
        int ans = -1;

        while(start<=end){
    
            int mid = start + (end-start)/2;
           
            if(target>nums[mid]){
                start = mid+1;
            }else if(target<nums[mid]){
                end = mid-1;
            }else{
    
                ans = mid;
                if(findStartElement){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        
        return ans;
    }
    
}