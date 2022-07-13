class Solution {
    public int findMin(int[] nums) {
        
        int start=0, end = nums.length-1, n = nums.length;
        
        if(nums[start]<=nums[end])return nums[start];
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            int midEle = nums[mid];
            int prev = (mid-1+n)%n;
            int next = (mid+1)%n;
            
            if(midEle<=nums[prev] && midEle<=nums[next])
                return midEle;
            
            if(midEle<nums[start])
                end = mid-1;
            else if(midEle>nums[end])
                start = mid+1;
            else 
                end = mid-1;
                        
        }
        return -1;
    }
}