class Solution {
    public int waysToSplitArray(int[] nums) {
        
        long totalSum =0, leftSum = 0, rightSum = 0;
        int count = 0;
        int n = nums.length-1;
        
        // System.out.println("len "+n+1);
        
        for(int e : nums)totalSum+=e;
        
        for(int i=0; i<n; i++){
            
            leftSum += nums[i];
            rightSum = totalSum - leftSum;
            
            if(leftSum>=rightSum)count++;
            
            
        }
        
        return count;
    }
}