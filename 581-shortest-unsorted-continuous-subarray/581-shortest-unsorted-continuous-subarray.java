class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = nums.length;
        int end = -1, begin = 0;
        
        
        for(int i=0;i<n;i++){
            int rev = n-i-1;
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[rev]);
            if(nums[i]<max)
                end = i;
            if(nums[rev]>min)
                begin = rev;
        }
        
//         for(int i=n-1;i>=0;i--){
            
//             min = Math.min(min,nums[i]);
//             if(nums[i]>min){
//                 begin=i;
//             }
//         }
        
//         for(int i=0;i<n;i++){
            
//             max = Math.max(max,nums[i]);
//             if(nums[i]<max)
//                 end = i;
//         }
        
        return end-begin +1;
    }
}