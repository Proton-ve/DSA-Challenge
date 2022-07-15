class Solution {
    public int findMin(int[] nums) {
        
        int start=0, end = nums.length-1, n = nums.length;
        
        if(nums[start]<=nums[end])return nums[start];
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            int midEle = nums[mid];
            // int prev = (mid-1+n)%n; // If mid is 0, then doing simply mid-1 will give indexoutofbound err, and mid will be 0 only if                                            array is sorted
            // int next = (mid+1)%n;
            
            int prev = mid>0 ? mid-1 : n-1;
            int next = mid<n-1 ? mid+1 : 0;
            
            if(midEle<=nums[prev] && midEle<=nums[next])
                return midEle;
            
            /**
            * Logic :::
            * Keep searching in unsorted part & eliminate sorted part
            * If both the part is sorted, then (keep searching in rightest part) min element shall exist in rightest part of array, as             * array is sorted.
            */
            
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