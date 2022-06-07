class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        Arrays.sort(nums);
        
        int i=0, j=i+1, count=0, n=nums.length-1;
        
        while(n>0 && i<n){
                        
            if(j<=n && nums[i]==nums[j]){
                count++;
                j++;
            }else{
                i++;
                j=i+1;
            }
            
        }
        
        return count;
    }
}